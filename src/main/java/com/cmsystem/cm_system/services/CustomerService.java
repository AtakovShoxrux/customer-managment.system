package com.cmsystem.cm_system.services;

import com.cmsystem.cm_system.entities.Customer;
import com.cmsystem.cm_system.exceptions.CustomerNotFoundException;
import com.cmsystem.cm_system.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllTheCustomers(){
        return customerRepository.findAll();
    }

    public Customer getTheCustomerById(Long theId) {
        return customerRepository.findById(theId).orElseThrow(() ->
                new CustomerNotFoundException("The required customer couldn't found!"));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long theId) {
        customerRepository.deleteById(theId);
    }
}