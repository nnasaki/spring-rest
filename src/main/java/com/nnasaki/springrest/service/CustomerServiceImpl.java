package com.nnasaki.springrest.service;

import com.nnasaki.springrest.domain.Customer;
import com.nnasaki.springrest.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Qualifier("customerRepository")
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {
    }

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer selectUser(Long id) {
        return customerRepository.findOne(id);
    }
}
