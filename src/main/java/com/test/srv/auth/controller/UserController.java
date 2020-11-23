package com.test.srv.auth.controller;

import com.test.srv.auth.dto.UserDTO;
import com.test.srv.auth.service.UserAccessPermissionService;
import com.test.srv.auth.service.UserService;
import com.test.srv.enumeration.CommonStatus;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jigme.dorji on 23/04/2020.
 */
@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/user")
public class UserController {
    //private region service
    @Autowired
    private UserService userService;

    @Autowired
    private UserAccessPermissionService userAccessPermissionService;

    //endregion

    //region public method

    /**
     * Index page
     *
     * @param model model
     * @return String
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("statusList", userService.getStatusList());
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        DateFormat currentDate;
        currentDate = new SimpleDateFormat("dd-MMM-yyyy");
        Date now = new Date();
        model.addAttribute("currentDate", currentDate.format(now));
        model.addAttribute("userRoleList", userAccessPermissionService.getUserRoleList());
        model.addAttribute("companyList", userAccessPermissionService.getCompanyList());
        model.addAttribute("statusActive", CommonStatus.Active.getValue());
        model.addAttribute("statusInactive", CommonStatus.Inactive.getValue());
        return "user";
    }

    /**
     * To check if login id already exists or not
     *
     * @param loginValue loginValue
     * @return ResponseMessage
     */
    @ResponseBody
    @RequestMapping(value = "/isLoginIdAlreadyExists", method = RequestMethod.GET)
    public ResponseMessage isLoginIdAlreadyExists(String loginValue) {
        return userService.isLoginIdAlreadyExists(loginValue);
    }

    /**
     * To get the list of data from the database
     *
     * @return List<UserDTO>
     */
    @ResponseBody
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public List<UserDTO> getUserList() {
        return userService.getUserList();
    }


    /**
     * To add new user
     *
     * @param userDTO userDTO
     * @return ResponseMessage
     */
    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseMessage addUser(HttpServletRequest request, UserDTO userDTO) {
        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return userService.addUser(userDTO, currentUser);
    }

    /**
     * To get the grid list to field
     *
     * @param userId loginId
     * @return UserDTO
     */
    @ResponseBody
    @RequestMapping(value = "/getUserDetail", method = RequestMethod.GET)
    public UserDTO getUserDetail(String userId) {
        return (UserDTO) userService.getUserDetail(userId).getDTO();
    }

    @ResponseBody
    @RequestMapping(value = "/getUserLog", method = RequestMethod.GET)
    public ResponseMessage getUserLog(String userId) {
        return userService.getUserLog(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/getUserLogDetail", method = RequestMethod.GET)
    public ResponseMessage getUserLogDetail(BigInteger userAuditId) {
        return userService.getUserLogDetail(userAuditId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ResponseMessage deleteUser(String userId) {
        return userService.deleteUser(userId);
    }
    //endregion

}
