package com.cmsystem.cm_system.contollers;

import com.cmsystem.cm_system.entities.Customer;
import com.cmsystem.cm_system.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allTheCustomers = customerService.getAllTheCustomers();
        return new ResponseEntity<>(allTheCustomers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> theCustomerById(@PathVariable("id") Long theId){
        Customer theCustomer = customerService.getTheCustomerById(theId);
        return new ResponseEntity<>(theCustomer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer theCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(theCustomer, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer theCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(theCustomer, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") Long theId){
        customerService.deleteCustomer(theId);
    }
}