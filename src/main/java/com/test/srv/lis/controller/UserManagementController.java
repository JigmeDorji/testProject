package com.test.srv.lis.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PreAuthorize("isAuthenticated()")


@RequestMapping("/userManagement")
public class UserManagementController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "userManagement";
    }

}
