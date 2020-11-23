/**
 * Component Name: Spare part management
 * Name: UserService
 * Description: See the description at the top of class declaration
 * Project: Spare part management
 * @author: bikash.rai
 * Creation: 22-Apr-2016
 * @version: 1.0.0
 * @since 2016
 * Language: Java 1.8.0_20
 * Copyright: (C) 2016
 */
package com.test.srv.auth.service;

import com.test.srv.auth.dao.UserDao;
import com.test.srv.auth.dto.UserDTO;
import com.test.srv.auth.entity.User;
import com.test.srv.auth.entity.User_a;
import com.test.srv.enumeration.CmdFlag;
import com.test.srv.enumeration.CommonStatus;
import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.DropdownDTO;
import com.test.srv.helper.MailSender;
import com.test.srv.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service()
@PreAuthorize("isAuthenticated()")
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    //region public method

    /**
     * To get the list of status
     *
     * @return List<DropdownDTO>
     */
    public List<DropdownDTO> getStatusList() {
        List<DropdownDTO> dropdownDTOs = new ArrayList<>();

        DropdownDTO dropdownDTOActiveStatus = new DropdownDTO();
        dropdownDTOActiveStatus.setValueChar(CommonStatus.Active.getValue());
        dropdownDTOActiveStatus.setText(CommonStatus.Active.getText());
        dropdownDTOs.add(dropdownDTOActiveStatus);

        DropdownDTO dropdownDTOInActiveStatus = new DropdownDTO();
        dropdownDTOInActiveStatus.setValueChar(CommonStatus.Inactive.getValue());
        dropdownDTOInActiveStatus.setText(CommonStatus.Inactive.getText());
        dropdownDTOs.add(dropdownDTOInActiveStatus);

        return dropdownDTOs;
    }

    /**
     * To validate if login ID already exists or not
     *
     * @param userId userId
     * @return ResponseMessage
     */
    public ResponseMessage isLoginIdAlreadyExists(String userId) {
        ResponseMessage responseMessage = new ResponseMessage();

        if (userDao.isLoginIdAlreadyExists(userId)) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setText(userId + " already exist in the system. Please choose different username.");
        }
        return responseMessage;
    }

    /**
     * To get the list of existing users
     *
     * @return
     */
    public List<UserDTO> getUserList() {
        return userDao.getUserList();
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvxyz0123456789";

    public static String generatePassword(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    /**
     * Method to save users into database
     *
     * @param userDTO     userDTO
     * @param currentUser currentUser
     * @return ResponseMessage
     */
    @Transactional(rollbackOn = Exception.class)
    public ResponseMessage addUser(UserDTO userDTO, CurrentUser currentUser) {
        ResponseMessage responseMessage = new ResponseMessage();
        Boolean isLoginIdExists = userDao.isLoginIdAlreadyExists(userDTO.getUserId());
        User user = new User();

        try {
            if (!isLoginIdExists) {
                responseMessage = checkEmailOnAddNew(userDTO);
                if (responseMessage.getStatus() == SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()) {
                    return responseMessage;
                }
                if (userDTO.getUserPassword().equals("")) {
                    userDTO.setUserPassword(generatePassword(6));//system generate 6 digits password
                }
                user.setUserId(userDTO.getUserId());
                user.setUserFullName(userDTO.getUserFullName());
                user.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
                user.setUserMobileNo(userDTO.getUserMobileNo());
                user.setUserStatus(userDTO.getUserStatus());
                user.setUserRoleTypeId(userDTO.getUserRoleTypeId());
                user.setCompanyId(userDTO.getCompanyId());
                user.setEmailId(userDTO.getEmailId());
                user.setUpdatedBy(null);
                user.setUpdatedDate(null);
                user.setCreatedBy(currentUser.getLoginId());
                user.setCreatedDate(new Date());
                User_a user_a = convertAuditDtoToEntity(user, CmdFlag.CREATE.getValue());
                userDao.addUser(user, user_a);
                sendMail(currentUser, userDTO, true);
                responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                responseMessage.setText("User added successfully.");
            } else {
                responseMessage = checkEmailOnUpdate(userDTO);
                if (responseMessage.getStatus() == SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()) {
                    return responseMessage;
                }
                String userInfoPWD = userDTO.getUserPassword();
                if (userInfoPWD.equals("")) {
                    String oldPassword = userDao.getOldPassword(userDTO.getUserId());
                    user.setUserPassword(oldPassword);
                } else {
                    user.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
                }
                user.setUserId(userDTO.getUserId());
                user.setUserFullName(userDTO.getUserFullName());
                user.setUserMobileNo(userDTO.getUserMobileNo());
                user.setUserStatus(userDTO.getUserStatus());
                user.setCompanyId(userDTO.getCompanyId());
                user.setEmailId(userDTO.getEmailId());
                user.setUserRoleTypeId(userDTO.getUserRoleTypeId());
                UserDTO userDTOdB = userDao.getUserDetail(userDTO.getUserId());
                user.setCreatedBy(userDTOdB.getCreatedBy());
                user.setCreatedDate(userDTOdB.getCreatedDate());
                user.setUpdatedBy(currentUser.getLoginId());
                user.setUpdatedDate(new Date());
                User_a user_a = convertAuditDtoToEntity(user, CmdFlag.MODIFY.getValue());
                userDao.updateUserInfo(user, user_a);
                sendMail(currentUser, userDTO, false);
                responseMessage.setText("User updated successfully.");
                responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            }

        } catch (Exception ex) {
            responseMessage.setText("Application Error.");
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            ex.printStackTrace();
        }
        return responseMessage;
    }

    public Boolean sendMail(CurrentUser currentUser, UserDTO userDTO, Boolean isCreation) throws Exception {
        String username = userDTO.getUserId();
        String password = userDTO.getUserPassword();
        String message;
        String subject;
        if (!isCreation) {
            subject = "DHI Land Information System - User Update";
            message = "Dear Sir/Madam <br> User has been updated against your email address " + userDTO.getEmailId()
                    + " to DHI Compact Automation System.<br>" +
                    "Please login to dhi.land.bt" +
                    "<br><br> This is an automated e-mail from DHI Land Information System. Please do not reply to this email.<br>Thank you.";
        } else {
            subject = "DHI Land Information System - User Creation";
            message = "Dear Sir/Madam <br> User has been created against your email address " + userDTO.getEmailId()
                    + " to DHI Compact Automation System.<br>" +
                    "User credentials are as below:<br>" +
                    "Username: " + username + "<br>" +
                    "Password: " + password + "<br>" +
                    "Please login to dhi.land.bt" +
                    "<br><br> This is an automated e-mail from DHI Land Information System. Please do not reply to this email.<br>Thank you.";
        }
        String toAddress = userDTO.getEmailId();
        String fromAddress = currentUser.getEmailId();
        return MailSender.sendMailWithoutFile(message, subject, toAddress, fromAddress);
    }


    /**
     * To get the grid value to fields
     *
     * @param userId loginId
     * @return ResponseMessage
     */

    public ResponseMessage getUserDetail(String userId) {
        ResponseMessage responseMessage = new ResponseMessage();
        UserDTO userDTO = userDao.getUserDetail(userId);
        if (userDTO == null) {
            responseMessage.setText("Data not available");
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
        } else {
            responseMessage.setDTO(userDTO);
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        }
        return responseMessage;
    }

    public ResponseMessage getUserLog(String userId) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<UserDTO> userDTOList = userDao.getUserLog(userId);
        if (userDTOList != null) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setDTO(userDTOList);
        }
        return responseMessage;
    }

    public ResponseMessage getUserLogDetail(BigInteger userAuditId) {
        ResponseMessage responseMessage = new ResponseMessage();
        UserDTO userDTO = userDao.getUserLogDetail(userAuditId);
        if (userDTO != null) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setDTO(userDTO);
        }
        return responseMessage;
    }

    public ResponseMessage deleteUser(String userId) {
        userDao.deleteUser(userId);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        responseMessage.setText("User has been deleted successfully.");
        return responseMessage;
    }
    //endregion

    //region private methods
    private ResponseMessage checkEmailOnAddNew(UserDTO userDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        String email = userDTO.getEmailId();
        String existingEmail = userDao.checkEmailOnAddNew(email);
        if (existingEmail != null) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setText("Email " + email + " already exist.");
        }
        return responseMessage;
    }

    private ResponseMessage checkEmailOnUpdate(UserDTO userDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        String email = userDTO.getEmailId();
        String username = userDTO.getUserId();
        String existingEmail = userDao.checkEmailOnUpdate(username, email);
        if (existingEmail != null) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setText("Email " + email + " already exist.");
        }
        return responseMessage;
    }

    private User_a convertAuditDtoToEntity(User user, Character cmdFlag) {
        User_a user_a = new User_a();
        BigInteger lastAuditId = userDao.getLastAuditId();
        lastAuditId = lastAuditId == null ? BigInteger.ONE : lastAuditId.add(lastAuditId);
        user_a.setUserAuditId(lastAuditId);
        user_a.setCmdFlag(cmdFlag);
        user_a.setUserId(user.getUserId());
        user_a.setUserPassword(user.getUserPassword());
        user_a.setUserFullName(user.getUserFullName());
        user_a.setUserMobileNo(user.getUserMobileNo());
        user_a.setUserStatus(user.getUserStatus());
        user_a.setCompanyId(user.getCompanyId());
        user_a.setEmailId(user.getEmailId());
        user_a.setUserRoleTypeId(user.getUserRoleTypeId());
        user_a.setCreatedBy(user.getCreatedBy());
        user_a.setCreatedDate(user.getCreatedDate());
        user_a.setUpdatedBy(user.getUpdatedBy());
        user_a.setUpdatedDate(user.getUpdatedDate());
        return user_a;
    }
    //endregion
}
