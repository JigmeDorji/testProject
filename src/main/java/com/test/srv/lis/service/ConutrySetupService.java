package com.test.srv.lis.service;

import com.test.srv.helper.BaseService;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportRequestDto;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.integration.jasper.report.service.ReportService;
import com.test.srv.lis.dao.CountrySetupDAO;
import com.test.srv.lis.dto.CountrySetupDTO;
import com.test.srv.lis.entity.CountrySetup;
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
public class ConutrySetupService extends BaseService {
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

    public List<CountrySetupDTO> getCountryName() {

        return countrySetupDAO.getCountryName();
    }

    public ResponseMessage deleteCountryId(Integer countryId) {
        ResponseMessage responseMessage = new ResponseMessage();
        countrySetupDAO.deleteCountryId(countryId);
        responseMessage.setStatus(1);
        responseMessage.setText("deleted succesfuly");
        return responseMessage;
    }

    @Transactional
    public ReportResponseDto generateReport(String reportType, Map<String, Object> params, String reportPath,
                                            String outputPath, Integer reportSelection, String userID) throws
            JRException, ClassNotFoundException, SQLException, ParseException {
        Connection connection = ((SessionImpl) getCurrentSession()).connection();

        String headerName = "";
        String footerName = "";

        reportPath = reportPath.replace("\\", "/");

        String reportJRXML = "/compact.documents/countrySetupReport.jrxml";
        String reportName = "countrySetupReport";

        headerName = ReportService.portraitHeaderName;
        footerName = ReportService.portraitFooterName;

        ReportRequestDto reportRequestDto = new ReportRequestDto(outputPath, reportName, reportType,
                reportPath + headerName, reportPath + reportJRXML, reportPath + footerName,
                reportPath, params, connection, userID);

        return ReportService.createReport(reportRequestDto);
    }
}
