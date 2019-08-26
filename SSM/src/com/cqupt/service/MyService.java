package com.cqupt.service;

import com.cqupt.dao.CustomerMapper;
import com.cqupt.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class MyService {

    @Autowired
    private CustomerMapper customerMapper;

    public Customer getCustomerById(Integer id) throws SQLException {
        Customer customer = customerMapper.getCustomerById(id);
        if (customer != null)
            return customer;
        else{
            System.out.println("没有对应的数据");
            throw new SQLException("No Corresponding Data Was Found");
        }
    }

    public void updateCustomer(Customer customer) {

        customerMapper.updateCustomer(customer);
    }
}
