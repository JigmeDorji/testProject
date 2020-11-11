package com.test.srv.lis.controller;

import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.BaseController;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.lis.dto.ChiwogRegistrationDTO;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.entity.StudentRegistration;
import com.test.srv.lis.service.ChiwogRegistrationService;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jigme.dorji on 11/8/2020.
 */
@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/chiwogRegistration")
public class ChiwogRegistrationController extends BaseController {

    @Autowired
    ChiwogRegistrationService chiwogRegistrationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(HttpServletRequest request, Model model) {
        return "chiwogRegistration";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage addCompany(HttpServletRequest request, ChiwogRegistrationDTO chiwogRegistrationDTO) throws IOException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return chiwogRegistrationService.save(chiwogRegistrationDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/getChiwogList", method = RequestMethod.GET)
    public List<ChiwogRegistrationDTO> getChiwogList() {
        return chiwogRegistrationService.getChiwogList();

    }

    @ResponseBody
    @RequestMapping(value = "/deleteChiwogInfoByChiwogId", method = RequestMethod.POST)
    public ResponseMessage deleteChiwogInfoByChiwogId(Integer chiwogId) {
        return chiwogRegistrationService.deleteChiwogInfoByChiwogId(chiwogId);

    }
    @ResponseBody
    @RequestMapping(value = "/generateReport", method = {RequestMethod.GET})
    public ResponseMessage generateReport(HttpServletRequest request, Integer companyId, Integer financialYearId, String fileFormat, Integer compactTypeId) throws JRException, SQLException, ClassNotFoundException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("reportTitle", "Chiwog Registration System");
        params.put("reportSubTitle", "Chiwog Negotiation Meeting");

        String reportSourcePath = getReportSourcePath(request);
        String reportOutputPath = getReportOutputPath(request);
        if (fileFormat == null || Objects.equals(fileFormat, "") || fileFormat.equalsIgnoreCase("Preview")) {
            fileFormat = "pdf";
        }
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            ReportResponseDto reportResponseDto = chiwogRegistrationService.generateReport(fileFormat, params,
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

