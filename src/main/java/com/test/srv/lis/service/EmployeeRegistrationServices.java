package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.EmployeeRegistrationDao;
import com.test.srv.lis.dto.EmployeeRegistrationDTO;
import com.test.srv.lis.entity.EmployeeRegistrationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRegistrationServices {

    @Autowired
    EmployeeRegistrationDao employeeRegistrationDao;

    public ResponseMessage save(EmployeeRegistrationDTO employeeRegistrationDTO) {
        EmployeeRegistrationEntity employeeRegistrationEntity = new EmployeeRegistrationEntity();

        employeeRegistrationEntity.setEmp_Name(employeeRegistrationDTO.getEmployeeName());
        employeeRegistrationEntity.setEmp_Designation(employeeRegistrationDTO.getEmployeeDesignation());
        employeeRegistrationEntity.setEmp_Department(employeeRegistrationDTO.getEmployeeDepartment());
        employeeRegistrationEntity.setEmp_Contact_No(employeeRegistrationDTO.getEmployeeContactNumber());

        employeeRegistrationDao.save(employeeRegistrationEntity);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("Employee Details saved successfully");
        return responseMessage;
    }


}
