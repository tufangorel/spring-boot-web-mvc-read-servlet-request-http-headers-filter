package com.company.customerinfo.service;


import com.company.customerinfo.model.Customer;
import com.company.customerinfo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    @Transactional
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer savewithException(Customer customer) {
        return customerRepository.save(customer);
    }
}