package com.test.srv.lis.service;

/**
 * Created by Yangkhor
 */

import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.BaseService;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.ItemGroupDao;
import com.test.srv.lis.dto.ItemGroupDTO;
import com.test.srv.lis.entity.ItemGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemGroupService extends BaseService {

    @Autowired
    ItemGroupDao itemGroupDao;

    public ResponseMessage saveItemGroup(ItemGroupDTO itemGroupDTO) {
        ItemGroup itemGroup = new ItemGroup();
        itemGroup.setItemgroup_id(itemGroupDTO.getItemgroup_id());
        itemGroup.setItem_group_name(itemGroupDTO.getItem_group_name());
        itemGroup.setItem_group_description(itemGroupDTO.getItem_group_description());
        itemGroup.setMandatory_item_group(itemGroupDTO.getMandatory_item_group());
        itemGroupDao.saveItemGroup(itemGroup);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        responseMessage.setText("Items Saved Successfully !");
        return responseMessage;
    }

//    public List<ItemGroupDTO> getItemGroup() {
//        return itemGroupDao.getItemGroup();
//    }
//
//    public ItemGroupDao getItemGroupDao() {
//        return itemGroupDao;
//    }
//
//    public void setItemGroupDao(ItemGroupDao itemGroupDao) {
//        this.itemGroupDao = itemGroupDao;
//    }
//
//    public ResponseMessage deleteItemGroup(Integer itemgroup_id) {
//        itemGroupDao.deleteItemGroup(itemgroup_id);
//        ResponseMessage responseMessage = new ResponseMessage();
//        responseMessage.setStatus(1);
//        responseMessage.setText("Item Group deleted successfully.");
//        return responseMessage;
//    }
}