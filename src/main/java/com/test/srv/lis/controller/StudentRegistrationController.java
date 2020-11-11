package com.test.srv.lis.controller;

import com.test.srv.enumeration.CommonStatus;
import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.BaseController;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.lis.dto.CompanyDTO;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.service.CompanyService;
import com.test.srv.lis.service.StudentRegistrationService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/studentRegistration")
public class StudentRegistrationController  extends BaseController {

    @Autowired
    StudentRegistrationService studentRegistrationService;


    @Autowired
    private CompanyService companyService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(HttpServletRequest request, Model model) {
        return "studentRegistration";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage saveStudent(HttpServletRequest request, StudentRegDTO studentRegDTO) throws IOException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return studentRegistrationService.save(studentRegDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/getCompanyList", method = RequestMethod.GET)
    public ResponseMessage getCompanyList() {
        return companyService.getCompanyList();
    }

    @ResponseBody
    @RequestMapping(value = "/getCompanyDetail", method = RequestMethod.GET)
    public CompanyDTO getCompanyDetail(Integer companyId) {
        return (CompanyDTO) companyService.getCompanyDetail(companyId).getDTO();
    }

    @ResponseBody
    @RequestMapping(value = "/generateReport", method = {RequestMethod.GET})
    public ResponseMessage generateReport(HttpServletRequest request, Integer companyId, Integer financialYearId, String fileFormat, Integer compactTypeId) throws JRException, SQLException, ClassNotFoundException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("reportTitle", "Board Committee for Performance Management Meeting (BCPM)");
        params.put("reportSubTitle", "Compact Negotiation Meeting");

        String reportSourcePath = getReportSourcePath(request);
        String reportOutputPath = getReportOutputPath(request);
        if (fileFormat == null || Objects.equals(fileFormat, "") || fileFormat.equalsIgnoreCase("Preview")) {
            fileFormat = "html";
        }
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            ReportResponseDto reportResponseDto = studentRegistrationService.generateReport(fileFormat, params,
                    reportSourcePath, reportOutputPath, 1, getCurrentUser(request).getLoginId(), compactTypeId);
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setDTO(reportResponseDto);
        } catch (Exception ex) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
            responseMessage.setText("Report generation failed. " + ex);
        }
        return responseMessage;
    }

}
