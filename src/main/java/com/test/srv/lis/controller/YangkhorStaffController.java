package com.test.srv.lis.controller;

import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.YangkhorStaffDTO;
import com.test.srv.lis.service.YangkhorStaffService;
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
@RequestMapping("/yangkhorStaff")
public class YangkhorStaffController {

    @Autowired
    YangkhorStaffService yangkhorStaffService;


    @RequestMapping(value="", method = RequestMethod.GET)
    public String index() {
        return "yangkhorStaff";


    }
    @ResponseBody
    @RequestMapping(value = "/yangkhorSaveDetail", method = RequestMethod.POST)
    public ResponseMessage yangkhorSaveDetail(HttpServletRequest request, YangkhorStaffDTO yangkhorStaffDTO) throws IOException {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return yangkhorStaffService.save(yangkhorStaffDTO);
    }
}
