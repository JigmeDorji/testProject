package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.BankaccountCreationDao;
import com.test.srv.lis.dto.BankaccountCreationDTO;
import com.test.srv.lis.entity.BankAccountCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankaccountCreationService {

    @Autowired
    BankaccountCreationDao bankaccountCreationDao;

    public ResponseMessage save(BankaccountCreationDTO bankaccountCreationDTO) {
        BankAccountCreation bankaccountCreation = new BankAccountCreation();

        bankaccountCreation.setBankaccountName(bankaccountCreationDTO.getBankaccountName());
        bankaccountCreation.setCidNo(bankaccountCreationDTO.getCidNo());
        bankaccountCreation.setMobileNo((bankaccountCreationDTO.getMobileNo()));
        bankaccountCreation.setEmailId((bankaccountCreationDTO.getEmailId()));
        bankaccountCreation.setDzongkhagId((bankaccountCreationDTO.getDzongkhagId()));
        bankaccountCreationDao.save(bankaccountCreation);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("SAVED SUCCESSFULLY !");
        return responseMessage;
    }
}
