
package com.test.srv.auth.service;

import com.test.srv.auth.dao.UserLoginDao;
import com.test.srv.auth.dto.UserDTO;
import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.MailSender;
import com.test.srv.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Service("userLoginService")
public class UserLoginService {
    //region private dao
    @Autowired
    UserLoginDao userLoginDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //endregion

    //region public method

    /**
     * to get user information while logging in.
     *
     * @param username username
     * @return UserDTO
     */
    public UserDTO login(String username) {
        return userLoginDao.login(username);
    }

    /**
     * reset forgot password
     *
     * @param emailId emailId
     * @return ResponseMessage ResponseMessage
     */
    public ResponseMessage forgotPasswordRecover(String username, String emailId) throws Exception {

        ResponseMessage responseMessage = new ResponseMessage();
        String existingEmail = userLoginDao.getEmail(username);
        if (!Objects.equals(existingEmail, emailId)) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setText("Username and email combination did not match.");
            return responseMessage;
        }
        if (userLoginDao.isEmailIdValid(emailId)) {
            String randomPassword = generateRandomPassword();
            userLoginDao.resetPassword(emailId, passwordEncoder.encode(randomPassword));
            String message = "Hello " + userLoginDao.getAddressName(emailId) + ", <br><br>" +
                    "Your password has been successfully reset. <br>" +
                    "Your new password is <strong>" + randomPassword + "</strong> <br><br>" +
                    "if you did not try to reset please do inform to concern person.<br><br><br>" +
                    "Thank you.";

            MailSender.sendMail(emailId, emailId, null, message, "Password Reset");

            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setText("Your password is successfully reset. Please check your email.");
        } else {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setText("Invalid EmailID. Please try with valid ID.");
        }

        return responseMessage;
    }

    private String generateRandomPassword() {
        return UUID.randomUUID()
                .toString().substring(0, 6);
    }
}
