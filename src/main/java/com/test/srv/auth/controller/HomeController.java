/**
 * Created by jigme.dorji on 23/04/2020.
 */
package com.test.srv.auth.controller;

import com.test.srv.auth.dto.UserDTO;
import com.test.srv.helper.CommonService;
import com.test.srv.helper.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping(value = "/")
@PreAuthorize("isAuthenticated()")
public class HomeController {

    @Autowired
    private CommonService commonService;

    /**
     * home controller
     *
     * @param request  request
     * @param response response
     *                 //     * @param authentication authentication
     * @return ModelAndView
     */

    @RequestMapping(value = {"/", "home"})
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        UserDTO userLoginDTO = (UserDTO) authentication.getPrincipal();

        CurrentUser currentUser = new CurrentUser();
        currentUser.setLoginId(userLoginDTO.getUserId());
        currentUser.setCreatedDate(userLoginDTO.getCreatedDate());
        currentUser.setTxtUserName(userLoginDTO.getUserFullName());
        currentUser.setUserStatus(userLoginDTO.getUserStatus());
        currentUser.setCompanyId(userLoginDTO.getCompanyId());
        currentUser.setCompanyName(userLoginDTO.getCompanyName());
        currentUser.setEmailId(userLoginDTO.getEmailId());
        currentUser.setRoleTypeId(userLoginDTO.getUserRoleTypeId());

        request.getSession().setAttribute("currentUser", currentUser);
        String viewPasswordExpiredNotice = (String) request.getSession().getAttribute("viewPasswordExpiredNotice");

        if (viewPasswordExpiredNotice == null) {
            int remainingDays = 0;
            request.getSession().setAttribute("viewPasswordExpiredNotice", String.valueOf(remainingDays));

            if (remainingDays > 0) {
                modelAndView.addObject("passwordExpiredNotice", "After " + remainingDays + " days, you will have to " +
                        "change password.");
            }
        }
        modelAndView.setViewName("home");
        return modelAndView;
    }
}