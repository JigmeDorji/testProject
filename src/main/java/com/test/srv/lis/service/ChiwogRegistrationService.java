package com.test.srv.lis.service;

/**
 * Created by jigme.dorji on 11/8/2020.
 */

import com.test.srv.helper.BaseService;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportRequestDto;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.integration.jasper.report.service.ReportService;
import com.test.srv.lis.dao.ChiwogRegistrationDao;
import com.test.srv.lis.dto.ChiwogRegistrationDTO;
import com.test.srv.lis.entity.ChiwogRegistration;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Service
public class ChiwogRegistrationService extends BaseService {

    @Autowired
    ChiwogRegistrationDao chiwogRegistrationDao;

    public ResponseMessage save(ChiwogRegistrationDTO chiwogRegistrationDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        ChiwogRegistration chiwogRegistration = new ChiwogRegistration();
        if(chiwogRegistrationDTO.getId() != null){
            chiwogRegistration.setId(chiwogRegistrationDTO.getId());
            chiwogRegistration.setChiwogName(chiwogRegistrationDTO.getChiwogName());
            chiwogRegistrationDao.update(chiwogRegistration);
            responseMessage.setStatus(1);
            responseMessage.setText("Chiwog Resgistration updated");
        }
        else{
            chiwogRegistration.setChiwogName(chiwogRegistrationDTO.getChiwogName());
            chiwogRegistrationDao.save(chiwogRegistration);
            responseMessage.setStatus(1);
            responseMessage.setText("Chiwog Resgistration save");
        }

        return responseMessage;

    }

    public List<ChiwogRegistrationDTO> getChiwogList() {
        return chiwogRegistrationDao.getChiwogList();
    }

    public ResponseMessage deleteChiwogInfoByChiwogId(Integer chiwogId) {
        ResponseMessage responseMessage = new ResponseMessage();
        chiwogRegistrationDao.deleteChiwogInfoByChiwogId(chiwogId);
        responseMessage.setStatus(1);
        responseMessage.setText("chiwog information succefully deleted");
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

        String reportJRXML  = "/compact.documents/chiwogRegistrationReport.jrxml";
        String reportName = "studentListReport";

        headerName = ReportService.portraitHeaderName;
        footerName = ReportService.portraitFooterName;

        ReportRequestDto reportRequestDto = new ReportRequestDto(outputPath, reportName, reportType,
                reportPath + headerName, reportPath + reportJRXML, reportPath + footerName,
                reportPath, params, connection, userID);

        return ReportService.createReport(reportRequestDto);
    }
}
