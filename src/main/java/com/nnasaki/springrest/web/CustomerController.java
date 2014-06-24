package com.nnasaki.springrest.web;

import com.nnasaki.springrest.domain.Customer;
import com.nnasaki.springrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer selectUser(@PathVariable Long id) {
        return customerService.selectUser(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer createUser(@RequestBody @Valid final Customer customer) {
        return customerService.save(customer);
    }

}