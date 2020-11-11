package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.EmployeeRegistrationDao;
import com.test.srv.lis.dto.EmployeeRegistrationDTO;
import com.test.srv.lis.entity.EmployeeRegistrationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRegistrationServices {

    @Autowired
    EmployeeRegistrationDao employeeRegistrationDao;

    public ResponseMessage save(EmployeeRegistrationDTO employeeRegistrationDTO) {
        EmployeeRegistrationEntity employeeRegistrationEntity = new EmployeeRegistrationEntity();

        ResponseMessage responseMessage = new ResponseMessage();

        if (employeeRegistrationDTO.getId() != null) {
            employeeRegistrationEntity.setId(employeeRegistrationDTO.getId());

            employeeRegistrationEntity.setEmp_Name(employeeRegistrationDTO.getEmployeeName());
            employeeRegistrationEntity.setEmp_Designation(employeeRegistrationDTO.getEmployeeDesignation());
            employeeRegistrationEntity.setEmp_Department(employeeRegistrationDTO.getEmployeeDepartment());
            employeeRegistrationEntity.setEmp_Contact_No(employeeRegistrationDTO.getEmployeeContactNumber());
            employeeRegistrationEntity.setEmp_Dob(employeeRegistrationDTO.getEmployeeDateOfBirth());

            employeeRegistrationDao.update(employeeRegistrationEntity);

            responseMessage.setStatus(1);
            responseMessage.setText("Employee Details Updated successfully");

        } else {

            employeeRegistrationEntity.setEmp_Name(employeeRegistrationDTO.getEmployeeName());
            employeeRegistrationEntity.setEmp_Designation(employeeRegistrationDTO.getEmployeeDesignation());
            employeeRegistrationEntity.setEmp_Department(employeeRegistrationDTO.getEmployeeDepartment());
            employeeRegistrationEntity.setEmp_Contact_No(employeeRegistrationDTO.getEmployeeContactNumber());
            employeeRegistrationEntity.setEmp_Dob(employeeRegistrationDTO.getEmployeeDateOfBirth());

            employeeRegistrationDao.save(employeeRegistrationEntity);
            responseMessage.setStatus(1);
            responseMessage.setText("Employee Details Save successfully");
        }

        return responseMessage;
    }


    public List<EmployeeRegistrationDTO> getEmployeeList() {
        return employeeRegistrationDao.getEmployeeList();
    }

    public ResponseMessage deleteEmployeeByEmployeeId(Integer employeeId) {

        ResponseMessage responseMessage = new ResponseMessage();
        employeeRegistrationDao.deleteEmployeeByEmployeeId(employeeId);
        responseMessage.setStatus(1);
        responseMessage.setText("Employee Information Delete successfully");
        return responseMessage;
    }
}
