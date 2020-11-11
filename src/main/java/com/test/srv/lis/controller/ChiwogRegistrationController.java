package com.test.srv.lis.controller;

import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.ChiwogRegistrationDTO;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.service.ChiwogRegistrationService;
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
 * Created by jigme.dorji on 11/8/2020.
 */
@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/chiwogRegistration")
public class ChiwogRegistrationController {

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
        return  chiwogRegistrationService.save(chiwogRegistrationDTO);
    }

}
