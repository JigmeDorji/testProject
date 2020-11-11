package com.test.srv.lis.service;


import com.test.srv.helper.BaseService;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportRequestDto;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.integration.jasper.report.service.ReportService;
import com.test.srv.lis.dao.CustomerSetupDao;
import com.test.srv.lis.dto.CustomerSetupDTO;
import com.test.srv.lis.entity.CustomerSetup;
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
public class CustomerSetupService extends BaseService {

    @Autowired
    private CustomerSetupDao customerSetupDao;

    public List<CustomerSetupDTO> getCustomerSetup() {
        return customerSetupDao.getCustomerSetup();
    }

    public CustomerSetupDao getCustomerSetupDao() {
        return customerSetupDao;
    }

    public void setCustomerSetupDao(CustomerSetupDao customerSetupDao) {
        this.customerSetupDao = customerSetupDao;
    }

    public ResponseMessage saveCustomerSetup(CustomerSetupDTO customerSetupDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        CustomerSetup customerSetup = new CustomerSetup();
        if (customerSetupDTO.getId() != null) {
            customerSetup.setId(customerSetupDTO.getId());
            customerSetup.setCustomerName(customerSetupDTO.getCustomerName());
            customerSetup.setContactNo(customerSetupDTO.getContactNo());
            customerSetupDao.update(customerSetup);
            responseMessage.setStatus(1);
            responseMessage.setText("Customer updated successfully.");

        }else {
            customerSetup.setCustomerName(customerSetupDTO.getCustomerName());
            customerSetup.setContactNo(customerSetupDTO.getContactNo());
            customerSetupDao.saveCustomerSetup(customerSetup);
            responseMessage.setStatus(1);
            responseMessage.setText("Customer saved successfully.");
        }



        return responseMessage;
    }

    public ResponseMessage delete(Integer id) {
         customerSetupDao.delete(id);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("Customer deleted successfully.");
        return responseMessage;
    }


    @Transactional
    public ReportResponseDto generateReport(String reportType, Map<String, Object> params, String reportPath,
                                            String outputPath, Integer reportSelection, String userID
            ) throws
            JRException, ClassNotFoundException, SQLException, ParseException {
        Connection connection = ((SessionImpl) getCurrentSession()).connection();

        String headerName = "";
        String footerName = "";

        reportPath = reportPath.replace("\\", "/");

        String reportJRXML  = "/compact.documents/tCustomerReport.jrxml";
        String reportName = "cutomerList";

        headerName = ReportService.portraitHeaderName;
        footerName = ReportService.portraitFooterName;

        ReportRequestDto reportRequestDto = new ReportRequestDto(outputPath, reportName, reportType,
                reportPath + headerName, reportPath + reportJRXML, reportPath + footerName,
                reportPath, params, connection, userID);

        return ReportService.createReport(reportRequestDto);
    }
}

