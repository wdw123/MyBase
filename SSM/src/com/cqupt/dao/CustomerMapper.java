package com.cqupt.dao;

import com.cqupt.model.Customer;

public interface CustomerMapper {

    Customer getCustomerById(Integer id);

    void updateCustomer(Customer customer);
}
