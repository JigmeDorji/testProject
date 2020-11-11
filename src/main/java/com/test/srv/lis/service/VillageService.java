package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.VillageDao;
import com.test.srv.lis.dto.VillageRegistrationDTO;
import com.test.srv.lis.entity.VillageRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VillageService {

    @Autowired
    VillageDao villageDao;

    public ResponseMessage save(VillageRegistrationDTO villageRegistrationDTO) {
        VillageRegistration villageRegistration = new VillageRegistration();
        villageRegistration.setVillageName((villageRegistrationDTO.getVillageName()));
        villageRegistration.setVillageId(villageRegistrationDTO.getVillageId());
        villageDao.save(villageRegistration);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("SAVED SUCCESSFULLY !");
        return responseMessage;
    }
}
