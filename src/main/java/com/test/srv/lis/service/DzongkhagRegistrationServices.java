package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.DzongkhagRegistrationDao;
import com.test.srv.lis.dto.DzongkhagRegDTO;
import com.test.srv.lis.entity.DzongkhagRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DzongkhagRegistrationServices {

   // DzongkhagRegistration dzongkhagRegistration = new DzongkhagRegistration();
   @Autowired
    DzongkhagRegistrationDao dzongkhagRegistrationDao;

    public ResponseMessage save(DzongkhagRegDTO dzongkhagRegDTO) {

        DzongkhagRegistration dzongkhagRegistration = new DzongkhagRegistration();

        dzongkhagRegistration.setDzongkhagName(dzongkhagRegDTO.getDzongkhagName());
        dzongkhagRegistration.setEmailAddress(dzongkhagRegDTO.getEmailAddress());

        dzongkhagRegistrationDao.save(dzongkhagRegistration); // entity dzongkhagRegistration

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("Dzongkhag Registration Saved Successfully!");
        return  responseMessage;

    }
}
