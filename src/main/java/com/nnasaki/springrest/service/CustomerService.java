package com.nnasaki.springrest.service;

import com.nnasaki.springrest.domain.Customer;

public interface CustomerService {
    Customer save(Customer customer);
    Customer selectUser(Long id);
}
