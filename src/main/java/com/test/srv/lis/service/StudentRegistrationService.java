package com.test.srv.lis.service;

import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.StudentRegistrationDao;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.entity.StudentRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: StudentRegistrationService
 * Date:  2020-Nov-08
 *
 * @author: Bikash Rai
 * @version: 1.0.0
 * ======================
 * Change History:
 * Version:1.0.0
 * Author:
 * Date: 2020-Nov-08
 * Change Description:
 * Search Tag:
 */
@Service
public class StudentRegistrationService {

    @Autowired
    StudentRegistrationDao studentRegistrationDao;

    public ResponseMessage save(StudentRegDTO studentRegDTO) {
        StudentRegistration studentRegistration = new StudentRegistration();
        studentRegistration.setStudentName(studentRegDTO.getStudentName());
        studentRegistrationDao.save(studentRegistration);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("Student Registration successfully saved.");
        return  responseMessage;
    }


}
