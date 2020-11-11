package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.YangkhorStaffDAO;
import com.test.srv.lis.dto.YangkhorStaffDTO;
import com.test.srv.lis.entity.YangkhorStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YangkhorStaffService {


    @Autowired
    YangkhorStaffDAO yangkhorStaffDAO;

    public ResponseMessage save(YangkhorStaffDTO yangkhorStaffDTO) {



        YangkhorStaff yangkhorStaff = new YangkhorStaff();
        yangkhorStaff.setStaffName(yangkhorStaffDTO.getStaffName());
        yangkhorStaffDAO.save(yangkhorStaff);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("Country Setup Successfully save.");

        return responseMessage;

    }
}
