package com.test.srv.lis.service;

import com.test.srv.helper.BaseService;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportRequestDto;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.integration.jasper.report.service.ReportService;
import com.test.srv.lis.dao.StudentRegistrationDao;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.entity.StudentRegistration;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.Objects;

import java.util.List;

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
public class StudentRegistrationService extends BaseService {

    @Autowired
    StudentRegistrationDao studentRegistrationDao;

    public ResponseMessage save(StudentRegDTO studentRegDTO) {
        StudentRegistration studentRegistration = new StudentRegistration();
        if (studentRegDTO.getStudentId() != null) { //update the info
            studentRegistration.setId(studentRegDTO.getStudentId());
            studentRegistration.setStudentName(studentRegDTO.getStudentName());
            studentRegistrationDao.update(studentRegistration);
        } else { //save new record
            studentRegistration.setStudentName(studentRegDTO.getStudentName());
            studentRegistrationDao.save(studentRegistration);

        }

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("Student Registration successfully saved.");
        return responseMessage;
    }


    public List<StudentRegDTO> getStudentList() {
        return studentRegistrationDao.getStudentList();
    }

    public ResponseMessage deleteStudentInfoByStudentId(Integer studentId) {
        ResponseMessage responseMessage = new ResponseMessage();
        studentRegistrationDao.deleteStudentInfoByStudentId(studentId);

        responseMessage.setStatus(1);
        responseMessage.setText("Student information deleted successfully.");
        return responseMessage;
    }

    @Transactional
    public ReportResponseDto generateReport(String reportType, Map<String, Object> params, String reportPath,
                                            String outputPath, Integer reportSelection, String userID, Integer compactTypeId) throws
            JRException, ClassNotFoundException, SQLException, ParseException {

        Connection connection = ((SessionImpl) getCurrentSession()).connection();

        String headerName = "";
        String footerName = "";

        reportPath = reportPath.replace("\\", "/");

        String reportJRXML  = "/compact.documents/StudentList.jrxml";
        String reportName = "cutomerList";

        headerName = ReportService.portraitHeaderName;
        footerName = ReportService.portraitFooterName;

        ReportRequestDto reportRequestDto = new ReportRequestDto(outputPath, reportName, reportType,
                reportPath + headerName, reportPath + reportJRXML, reportPath + footerName,
                reportPath, params, connection, userID);

        return ReportService.createReport(reportRequestDto);
    }

}
