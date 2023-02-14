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
    public ResponseEntity<List<Customer>> listCustomer(@RequestParam(name = "customerId", required = false) Long customerTypeId){
        List<Customer> customers;
        if(Optional.ofNullable(customerTypeId).isEmpty()){
            customers = customerService.listAllCustomer();
        }else{
            customers = customerService.findByCustomerType(CustomerType.builder().id(customerTypeId).build());
        }
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer( @RequestBody Customer customer){

        Customer customerCreate =  customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
    }

    @GetMapping(value = "/{document}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("document") Long document) {
        Customer customer =  customerService.findByDocument(document);
        if (null==customer){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer) {
        customer.setId(id);
        Customer customerUpdate =  customerService.updateCustomer(customer);
        if (null==customer){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerUpdate);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> deleteProduct(@PathVariable("id") Long id){
        Customer customer =  customerService.deleteCustomer(id);
        if (null==customer){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

}
