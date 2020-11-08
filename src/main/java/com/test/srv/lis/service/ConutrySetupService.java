package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.CountrySetupDAO;
import com.test.srv.lis.dto.countrySetupDTO;
import com.test.srv.lis.entity.CountrySetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConutrySetupService {
    @Autowired
    CountrySetupDAO countrySetupDAO;

    public ResponseMessage save(countrySetupDTO countrySetupDTO) {
        CountrySetup countrySetup = new CountrySetup();
        countrySetup.setCountryName(countrySetupDTO.getCountryName());
        countrySetupDAO.save(countrySetup);

    ResponseMessage responseMessage= new ResponseMessage();
    responseMessage.setStatus(1);
    responseMessage.setText("Country Setup Successfully save.");

    return responseMessage;

    }
}
