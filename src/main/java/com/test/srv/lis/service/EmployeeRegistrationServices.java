package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.lis.dao.EmployeeRegistrationDao;
import com.test.srv.lis.dto.EmployeeRegistrationDTO;
import com.test.srv.lis.entity.EmployeeRegistrationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

            employeeRegistrationEntity.setEmp_Dzongkhag_Id(employeeRegistrationDTO.getEmployeeDzongkhagId());
            employeeRegistrationEntity.setEmp_Gewog_Id(employeeRegistrationDTO.getEmployeeGewogId());

            employeeRegistrationDao.update(employeeRegistrationEntity);

            responseMessage.setStatus(1);
            responseMessage.setText("Employee Details Updated successfully");

        } else {

            employeeRegistrationEntity.setEmp_Name(employeeRegistrationDTO.getEmployeeName());
            employeeRegistrationEntity.setEmp_Designation(employeeRegistrationDTO.getEmployeeDesignation());
            employeeRegistrationEntity.setEmp_Department(employeeRegistrationDTO.getEmployeeDepartment());
            employeeRegistrationEntity.setEmp_Contact_No(employeeRegistrationDTO.getEmployeeContactNumber());
            employeeRegistrationEntity.setEmp_Dob(employeeRegistrationDTO.getEmployeeDateOfBirth());

            employeeRegistrationEntity.setEmp_Dzongkhag_Id(employeeRegistrationDTO.getEmployeeDzongkhagId());
            employeeRegistrationEntity.setEmp_Gewog_Id(employeeRegistrationDTO.getEmployeeGewogId());

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

    public ReportResponseDto generateReport(String fileFormat, Map<String, Object> params, String reportSourcePath, String reportOutputPath, int i, String loginId, Integer compactTypeId) {

        return null;
    }
}
