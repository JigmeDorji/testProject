package com.test.srv.lis.controller;

import com.test.srv.auth.dto.UserDTO;
import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.BaseController;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.lis.dto.EmployeeRegistrationDTO;
import com.test.srv.lis.service.EmployeeRegistrationServices;
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

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/employeeRegistration")
public class EmployeeRegistrationController extends BaseController {

    @Autowired
    EmployeeRegistrationServices employeeRegistrationServices;
    @RequestMapping(value="", method = RequestMethod.GET)
    public String index() {

        return "employeeRegistrationForm";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage saveEmployee(HttpServletRequest request, EmployeeRegistrationDTO employeeRegistrationDTO) throws IOException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return employeeRegistrationServices.save(employeeRegistrationDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET)
    public List<EmployeeRegistrationDTO> getEmployeeList() {
        return employeeRegistrationServices.getEmployeeList();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteEmployeeByEmployeeId", method = RequestMethod.POST)
    public ResponseMessage deleteEmployeeByEmployeeId(Integer employeeId) {
        return employeeRegistrationServices.deleteEmployeeByEmployeeId(employeeId);
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
            ReportResponseDto reportResponseDto = employeeRegistrationServices.generateReport(fileFormat, params,
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
