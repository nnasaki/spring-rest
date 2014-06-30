package com.nnasaki.springrest.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    Customer findByEmailAddress(EmailAddress email);
    List<Customer> findByAddresses_City(String city);
}
