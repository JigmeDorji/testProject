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

import java.util.List;

@Service
public class ChiwogRegistrationService {

    @Autowired
    ChiwogRegistrationDao chiwogRegistrationDao;

    public ResponseMessage save(ChiwogRegistrationDTO chiwogRegistrationDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        ChiwogRegistration chiwogRegistration = new ChiwogRegistration();
        if(chiwogRegistrationDTO.getId() != null){
            chiwogRegistration.setId(chiwogRegistrationDTO.getId());
            chiwogRegistration.setChiwogName(chiwogRegistrationDTO.getChiwogName());
            chiwogRegistrationDao.update(chiwogRegistration);
            responseMessage.setStatus(1);
            responseMessage.setText("Chiwog Resgistration updated");
        }
        else{
            chiwogRegistration.setChiwogName(chiwogRegistrationDTO.getChiwogName());
            chiwogRegistrationDao.save(chiwogRegistration);
            responseMessage.setStatus(1);
            responseMessage.setText("Chiwog Resgistration save");
        }

        return responseMessage;

    }

    public List<ChiwogRegistrationDTO> getChiwogList() {
        return chiwogRegistrationDao.getChiwogList();
    }

    public ResponseMessage deleteChiwogInfoByChiwogId(Integer chiwogId) {
        ResponseMessage responseMessage = new ResponseMessage();
        chiwogRegistrationDao.deleteChiwogInfoByChiwogId(chiwogId);
        responseMessage.setStatus(1);
        responseMessage.setText("chiwog information succefully deleted");
        return responseMessage;
    }
}
