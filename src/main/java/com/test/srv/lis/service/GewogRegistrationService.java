package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.GewogRegistrationDao;
import com.test.srv.lis.dto.GewogRegistrationDTO;
import com.test.srv.lis.entity.GewogRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GewogRegistrationService {

    @Autowired
    GewogRegistrationDao gewogRegistrationDao;

    public ResponseMessage save(GewogRegistrationDTO gewogRegistrationDTO) {

        GewogRegistration gewogRegistration = new GewogRegistration();
        gewogRegistration.setGewogName(gewogRegistrationDTO.getGewogName());

        gewogRegistrationDao.save(gewogRegistration);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("Gewog saved successfully");
        return responseMessage;
    }
}
