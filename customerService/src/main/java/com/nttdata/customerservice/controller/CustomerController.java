package com.nttdata.customerservice.controller;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import com.nttdata.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<Customer>> listCustomer(@RequestParam(name = "categoryId", required = false) Long customerTypeId){
        List<Customer> customers;
        if(Optional.ofNullable(customerTypeId).isEmpty()){
            customers = customerService.listAllCustomer();
        }else{
            customers = customerService.findByCustomerType(CustomerType.builder().id(customerTypeId).build());
        }
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Customer> createProduct( @RequestBody Customer customer){

        Customer customerCreate =  customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
    }

}
