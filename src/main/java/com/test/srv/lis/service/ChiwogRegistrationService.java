package com.test.srv.lis.service;

/**
 * Created by jigme.dorji on 11/8/2020.
 */

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.ChiwogRegistrationDao;
import com.test.srv.lis.dto.ChiwogRegistrationDTO;
import com.test.srv.lis.entity.ChiwogRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiwogRegistrationService {

    @Autowired
    ChiwogRegistrationDao chiwogRegistrationDao;

    public ResponseMessage save(ChiwogRegistrationDTO chiwogRegistrationDTO) {
        ChiwogRegistration chiwogRegistration = new ChiwogRegistration();
        chiwogRegistration.setChiwogName(chiwogRegistrationDTO.getChiwogName());
        chiwogRegistrationDao.save(chiwogRegistration);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("Chiwog Resgistration successfully saved");
        return responseMessage;

    }
}
