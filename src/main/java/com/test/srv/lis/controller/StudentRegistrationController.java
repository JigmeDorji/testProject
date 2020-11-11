package com.test.srv.lis.controller;

import com.test.srv.auth.dto.UserDTO;
import com.test.srv.enumeration.CommonStatus;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.CompanyDTO;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.service.CompanyService;
import com.test.srv.lis.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/studentRegistration")
public class StudentRegistrationController {

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
    @RequestMapping(value = "/getStudentList", method = RequestMethod.GET)
    public List<StudentRegDTO> getStudentList() {
        return studentRegistrationService.getStudentList();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteStudentInfoByStudentId", method = RequestMethod.POST)
    public ResponseMessage deleteStudentInfoByStudentId(Integer studentId) {
        return studentRegistrationService.deleteStudentInfoByStudentId(studentId);
    }

}
