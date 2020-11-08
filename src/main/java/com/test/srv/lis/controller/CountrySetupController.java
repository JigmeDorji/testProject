package com.test.srv.lis.controller;

import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.dto.countrySetupDTO;
import com.test.srv.lis.service.ConutrySetupService;
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
@RequestMapping("/countrySetup")
public class CountrySetupController {

    @Autowired
    ConutrySetupService conutrySetupService;


    @RequestMapping(value="", method = RequestMethod.GET)
    public String index() {
    return "countrySetup";


    }
    @ResponseBody
    @RequestMapping(value = "/countrySaveDetail", method = RequestMethod.POST)
    public ResponseMessage countrySaveDetail(HttpServletRequest request, countrySetupDTO countrySetupDTO) throws IOException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return conutrySetupService.save(countrySetupDTO);
    }
}
