package com.test.srv.lis.controller;

import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.BaseController;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.lis.dto.CustomerSetupDTO;
import com.test.srv.lis.service.CustomerSetupService;
import com.test.srv.lis.service.StudentRegistrationService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Description: CustomerSetup
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
@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/customerSetup")
public class CustomerSetupController extends BaseController {
    @Autowired
    private CustomerSetupService customerSetupService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "customerSetup";
    }


    @ResponseBody
    @RequestMapping(value = "/getCustomerSetup", method = RequestMethod.GET)
    public List<CustomerSetupDTO> getCustomerSetup() throws IOException {
        return customerSetupService.getCustomerSetup();
    }
    @ResponseBody
    @RequestMapping(value = "/saveCustomerSetup", method = RequestMethod.POST)
    public ResponseMessage saveCustomerSetup(CustomerSetupDTO customerSetupDTO) throws IOException {
        return customerSetupService.saveCustomerSetup(customerSetupDTO);
    }
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseMessage delete(Integer id) throws IOException {
        return customerSetupService.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/generateCustomer", method = {RequestMethod.GET})
    public ResponseMessage generateReport(HttpServletRequest request,   String fileFormat, Integer compactTypeId) throws JRException,
            SQLException, ClassNotFoundException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("reportTitle", "fsdfs");
        params.put("reportSubTitle", "sda");

        String reportSourcePath = getReportSourcePath(request);
        String reportOutputPath = getReportOutputPath(request);
        if (fileFormat == null || Objects.equals(fileFormat, "") || fileFormat.equalsIgnoreCase("Preview")) {
            fileFormat = "pdf";
        }
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            ReportResponseDto reportResponseDto = customerSetupService.generateReport(fileFormat, params,
                    reportSourcePath, reportOutputPath, 1, getCurrentUser(request).getLoginId());
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setDTO(reportResponseDto);
        } catch (Exception ex) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setText("Report generation failed. " + ex);
        }
        return responseMessage;
    }

}



