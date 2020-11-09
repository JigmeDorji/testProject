package com.test.srv.lis.controller;

import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.EmployeeRegistrationDTO;
import com.test.srv.lis.service.EmployeeRegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/employeeRegistration")
public class EmployeeRegistrationController {

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

}
