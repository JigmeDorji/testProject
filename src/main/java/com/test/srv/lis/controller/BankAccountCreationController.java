package com.test.srv.lis.controller;

import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.BankaccountCreationDTO;
import com.test.srv.lis.dto.ChiwogRegistrationDTO;
import com.test.srv.lis.service.BankaccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller("isAuthenticated()")
@RequestMapping("/bankaccountRegistration")
public class BankAccountCreationController {

    @Autowired
    BankaccountCreationService bankaccountCreationService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(HttpServletRequest request, Model model) {
        return "bankaccountCreation";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage addCompany(HttpServletRequest request, BankaccountCreationDTO bankaccountCreationDTO) throws IOException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return bankaccountCreationService.save(bankaccountCreationDTO);
    }
}
