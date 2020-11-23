/**
 * Created by jigme.dorji on 23/04/2020.
 */
package com.test.srv.auth.service;

import com.test.srv.auth.dao.ChangePasswordDao;
import com.test.srv.auth.dto.ChangePasswordDTO;
import com.test.srv.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("changePasswordService")
public class ChangePasswordService {
    //region private dao
    @Autowired
    private ChangePasswordDao changePasswordDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    //endregion

    //region public method

    /**
     * save method.
     *
     * @param changePasswordDTO changePasswordDTO
     * @return ResponseMessage
     */
    public ResponseMessage save(ChangePasswordDTO changePasswordDTO) {
        ResponseMessage responseMessage = new ResponseMessage();

        String oldPWD = changePasswordDao.getOldCredentials(changePasswordDTO.getUserId());

        if (passwordEncoder.matches(changePasswordDTO.getOldPassword(), oldPWD)) {
            changePasswordDao.updateUserPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()),
                    changePasswordDTO.getUserId());
            responseMessage.setStatus(1);
            responseMessage.setText("Password changed successfully.");
        } else {
            responseMessage.setStatus(0);
            responseMessage.setText("Invalid password.");
        }

        return responseMessage;
    }
    //endregion

}
