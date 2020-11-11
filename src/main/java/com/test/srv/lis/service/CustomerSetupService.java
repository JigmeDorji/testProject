package com.test.srv.lis.service;


import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.CustomerSetupDao;
import com.test.srv.lis.dto.CustomerSetupDTO;
import com.test.srv.lis.entity.CustomerSetup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerSetupService {

    @Autowired
    private CustomerSetupDao customerSetupDao;

    public List<CustomerSetupDTO> getCustomerSetup() {
        return customerSetupDao.getCustomerSetup();
    }

    public CustomerSetupDao getCustomerSetupDao() {
        return customerSetupDao;
    }

    public void setCustomerSetupDao(CustomerSetupDao customerSetupDao) {
        this.customerSetupDao = customerSetupDao;
    }

    public ResponseMessage saveCustomerSetup(CustomerSetupDTO customerSetupDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        CustomerSetup customerSetup = new CustomerSetup();
        if (customerSetupDTO.getId() != null) {
            customerSetup.setId(customerSetupDTO.getId());
            customerSetup.setCustomerName(customerSetupDTO.getCustomerName());
            customerSetup.setContactNo(customerSetupDTO.getContactNo());
            customerSetupDao.update(customerSetup);
            responseMessage.setStatus(1);
            responseMessage.setText("Customer updated successfully.");

        }else {
            customerSetup.setCustomerName(customerSetupDTO.getCustomerName());
            customerSetup.setContactNo(customerSetupDTO.getContactNo());
            customerSetupDao.saveCustomerSetup(customerSetup);
            responseMessage.setStatus(1);
            responseMessage.setText("Customer saved successfully.");
        }



        return responseMessage;
    }

    public ResponseMessage delete(Integer id) {
         customerSetupDao.delete(id);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(1);
        responseMessage.setText("Customer deleted successfully.");
        return responseMessage;
    }
}

