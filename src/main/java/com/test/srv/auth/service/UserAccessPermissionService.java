package com.test.srv.auth.service;

import com.test.srv.auth.dao.UserAccessPermissionDao;
import com.test.srv.auth.dto.UserAccessPermissionDTO;
import com.test.srv.auth.dto.UserAccessPermissionListDTO;
import com.test.srv.auth.entity.UserAccessPermission;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.DropdownDTO;
import com.test.srv.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Service("userAccessPermissionService")
public class UserAccessPermissionService {

    @Autowired
    private UserAccessPermissionDao userAccessPermissionDao;

    public List<DropdownDTO> getUserRoleList() {
        return userAccessPermissionDao.getUserRoleList();
    }

    public List<UserAccessPermissionListDTO> getScreenList(Integer userRoleTypeId) {

        List<UserAccessPermissionListDTO> userAccessPermissionListDTOList;
        if (userAccessPermissionDao.isUserRoleAssigned(userRoleTypeId)) {
            userAccessPermissionListDTOList = userAccessPermissionDao.getScreenList(userRoleTypeId);
        } else {
            userAccessPermissionListDTOList = userAccessPermissionDao.getUnScreenList();
        }
        return userAccessPermissionListDTOList;
    }

    public ResponseMessage save(UserAccessPermissionDTO userAccessPermissionDTO, CurrentUser currentUser) {
        UserAccessPermission userAccessPermission = new UserAccessPermission();
        ResponseMessage responseMessage = new ResponseMessage();
        BigInteger userAccessPermissionIdSerial = userAccessPermissionDao.getUserAccessPermissionIdSerial();
        userAccessPermissionIdSerial = userAccessPermissionIdSerial == null ? BigInteger.ONE : userAccessPermissionIdSerial;
        for (UserAccessPermissionListDTO userAccessPermissionListDTO : userAccessPermissionDTO.getUserAccessPermissionListDTO()) {
            userAccessPermission.setScreenId(userAccessPermissionListDTO.getScreenId());
            userAccessPermission.setUserRoleTypeId(userAccessPermissionDTO.getUserRoleTypeId());
            userAccessPermission.setIsScreenAccessAllowed(userAccessPermissionListDTO.getIsScreenAccessAllowed());
            userAccessPermission.setIsEditAccessAllowed(userAccessPermissionListDTO.getIsEditAccessAllowed());
            userAccessPermission.setIsDeleteAccessAllowed(userAccessPermissionListDTO.getIsDeleteAccessAllowed());
            userAccessPermission.setIsSaveAccessAllowed(userAccessPermissionListDTO.getIsSaveAccessAllowed());
            userAccessPermission.setCreatedBy(currentUser.getLoginId());
            userAccessPermission.setCreatedDate(currentUser.getCreatedDate());
            if (userAccessPermissionListDTO.getUserAccessPermissionId() != null) {
                userAccessPermission.setUserAccessPermissionId(userAccessPermissionListDTO.getUserAccessPermissionId());
                userAccessPermissionDao.update(userAccessPermission);
            } else {
                userAccessPermission.setUserAccessPermissionId(userAccessPermissionIdSerial.add(userAccessPermissionIdSerial));
                userAccessPermissionIdSerial = userAccessPermissionIdSerial.add(userAccessPermissionIdSerial);
                userAccessPermissionDao.save(userAccessPermission);
            }
        }
        responseMessage.setStatus(1);
        responseMessage.setText("Data saved successfully.");
        return responseMessage;
    }

    public List<UserAccessPermissionListDTO> getUserAccessPermissionDetails(Integer roleTypeId) {
        return userAccessPermissionDao.getScreenList(roleTypeId);
    }

    public List<DropdownDTO> getCompanyList() {
        return userAccessPermissionDao.getCompanyList();
    }
}
