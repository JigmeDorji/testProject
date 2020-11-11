package com.test.srv.lis.controller;

import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.CustomerSetupDTO;
import com.test.srv.lis.service.CustomerSetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Description: CustomerSetup
 * Date:  2020-Nov-08
 *
 * @author: Bikash Rai
 * @version: 1.0.0
 * ======================
 * Change History:
 * Version:1.0.0
 * Author:
 * Date: 2020-Nov-08
 * Change Description:
 * Search Tag:
 */
@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/customerSetup")
public class CustomerSetupController {
    @Autowired
    private CustomerSetupService customerSetupService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "customerSetup";
    }


    @ResponseBody
    @RequestMapping(value = "/getCustomerSetup", method = RequestMethod.GET)
    public List<CustomerSetupDTO> getCustomerSetup() throws IOException {
        return customerSetupService.getCustomerSetup();
    }
    @ResponseBody
    @RequestMapping(value = "/saveCustomerSetup", method = RequestMethod.POST)
    public ResponseMessage saveCustomerSetup(CustomerSetupDTO customerSetupDTO) throws IOException {
        return customerSetupService.saveCustomerSetup(customerSetupDTO);
    }
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseMessage delete(Integer id) throws IOException {
        return customerSetupService.delete(id);
    }

}
