package com.test.srv.lis.controller;

import com.test.srv.enumeration.CommonStatus;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.CompanyDTO;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by nzepa on 10/11/2020.
 */
@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/studentRegistration")
public class StudentRegistrationController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(HttpServletRequest request, Model model) {
        return "studentRegistration";
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
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage addCompany(HttpServletRequest request, StudentRegDTO studentRegDTO) throws IOException {
//        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return null;
    }
}
