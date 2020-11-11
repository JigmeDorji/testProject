package com.test.srv.lis.controller;

import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.BaseController;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.integration.jasper.report.domain.dto.ReportResponseDto;
import com.test.srv.lis.dto.CountrySetupDTO;
import com.test.srv.lis.service.ConutrySetupService;
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

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/countrySetup")
public class CountrySetupController extends BaseController {
    @Autowired
    ConutrySetupService conutrySetupService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "countrySetup";
    }

    @ResponseBody
    @RequestMapping(value = "/countrySaveDetail", method = RequestMethod.POST)
    public ResponseMessage countrySaveDetail(HttpServletRequest request, CountrySetupDTO countrySetupDTO) throws IOException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return conutrySetupService.save(countrySetupDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/getCountryName", method = RequestMethod.GET)
    public List<CountrySetupDTO> getCountryNam() {
        return conutrySetupService.getCountryName();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteCountryId", method = RequestMethod.POST)
    public ResponseMessage deleteCountryId(Integer countryId) {
        return conutrySetupService.deleteCountryId(countryId);
    }

    @ResponseBody
    @RequestMapping(value = "/reportCountryList", method = {RequestMethod.GET})
    public ResponseMessage generateReport(HttpServletRequest request, String fileFormat) throws JRException, SQLException, ClassNotFoundException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("reportTitle", "tEARONMIG");
        params.put("reportSubTitle", "gniasdnOG");

        String reportSourcePath = getReportSourcePath(request);
        String reportOutputPath = getReportOutputPath(request);
        if (fileFormat == null || Objects.equals(fileFormat, "") || fileFormat.equalsIgnoreCase("Preview")) {
            fileFormat = "xls";
        }
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            ReportResponseDto reportResponseDto = conutrySetupService.generateReport(fileFormat, params,
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

