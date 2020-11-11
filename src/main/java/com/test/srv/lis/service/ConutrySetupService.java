package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.CountrySetupDAO;
import com.test.srv.lis.dto.CountrySetupDTO;
import com.test.srv.lis.entity.CountrySetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConutrySetupService {
    @Autowired
    CountrySetupDAO countrySetupDAO;

    public ResponseMessage save(CountrySetupDTO countrySetupDTO) {
        CountrySetup countrySetup = new CountrySetup();
        ResponseMessage responseMessage = new ResponseMessage();
        if (countrySetupDTO.getId() != null) {//update
            countrySetup.setId(countrySetupDTO.getId());//update
            countrySetup.setCountryName(countrySetupDTO.getCountryName());//update
            countrySetupDAO.update(countrySetup);//updat
            responseMessage.setText("Country Setup Successfully updated.");

        } else {
            countrySetup.setCountryName(countrySetupDTO.getCountryName());
            countrySetupDAO.save(countrySetup);
            responseMessage.setText("Country Setup Successfully save.");

        }

        responseMessage.setStatus(1);

        return responseMessage;

    }

    public List<CountrySetupDTO> getCountryName(){

        return countrySetupDAO.getCountryName();
    }

    public ResponseMessage deleteCountryId(Integer countryId) {
        ResponseMessage responseMessage = new ResponseMessage();
        countrySetupDAO.deleteCountryId(countryId);
        responseMessage.setStatus(1);
        responseMessage.setText("deleted succesfuly");
        return responseMessage;
    }

}
