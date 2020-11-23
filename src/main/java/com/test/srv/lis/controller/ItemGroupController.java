package com.test.srv.lis.controller;

import com.test.srv.helper.BaseController;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dto.ItemGroupDTO;
import com.test.srv.lis.service.ItemGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@PreAuthorize("isAuthenticated()")

@RequestMapping("/itemGroup")
public class ItemGroupController extends BaseController {

    @Autowired
    private ItemGroupService itemGroupService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "itemGroup";
    }

    @ResponseBody
    @RequestMapping(value = "/saveItemGroup", method = RequestMethod.POST)
    public ResponseMessage saveItemGroup(ItemGroupDTO itemGroupDTO) throws IOException {
        return itemGroupService.saveItemGroup(itemGroupDTO);
    }
//
//    @ResponseBody
//    @RequestMapping(value = "/getItemGroup", method = RequestMethod.GET)
//    public List<ItemGroupDTO> getItemGroup() throws IOException {
//        return itemGroupService.getItemGroup();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/deleteItemGroup", method = RequestMethod.POST)
//    public ResponseMessage deleteItemGroup(Integer itemgroup_id) throws IOException {
//        return itemGroupService.deleteItemGroup(itemgroup_id);
//    }

}
