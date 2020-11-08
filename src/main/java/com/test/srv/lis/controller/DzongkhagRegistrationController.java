package com.test.srv.lis.controller;

import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.DzongkhagRegDTO;
import com.test.srv.lis.dto.StudentRegDTO;
import com.test.srv.lis.service.DzongkhagRegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/dzongkhagRegistration")
public class DzongkhagRegistrationController {

    @Autowired
    DzongkhagRegistrationServices dzongkhagRegistrationServices;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(HttpServletRequest request, Model model) {
        return "dzongkhagRegistration";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage saveDzongkhag(HttpServletRequest request, DzongkhagRegDTO dzongkhagRegDTO) throws IOException {
       CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return dzongkhagRegistrationServices.save(dzongkhagRegDTO);
    }

}


