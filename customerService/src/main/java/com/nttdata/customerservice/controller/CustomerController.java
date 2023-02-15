package com.nttdata.customerservice.controller;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import com.nttdata.customerservice.service.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * * Ignore try block, but keep catch and finally blocks.
 *
 */
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  /**
   * * Ignore try block, but keep catch and finally blocks.
   *
   * @param customerTypeId asdasd
   * @return CustomerList asdasdsa
   */
  @GetMapping
  public ResponseEntity<List<Customer>> listCustomer(
          @RequestParam(name = "customerId", required = false) Long customerTypeId) {
    List<Customer> customers;
    if (Optional.ofNullable(customerTypeId).isEmpty()) {
      customers = customerService.listAllCustomer();
    } else {
      customers = customerService.findByCustomerType(
              CustomerType.builder()
                      .id(customerTypeId)
                      .build());
    }
    return ResponseEntity.ok(customers);
  }

  /**
   * * Ignore try block, but keep catch and finally blocks.
   *
   * @param customer asdasd
   * @return Customer asdasdsa
   */
  @PostMapping
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    Customer customerCreate =  customerService.createCustomer(customer);
    return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
  }

  /**
   * * Ignore try block, but keep catch and finally blocks.
   *
   * @param document asdasd
   * @return CustomerList asdasdsa
   */
  @GetMapping(value = "/{document}")
  public ResponseEntity<Customer> getCustomer(@PathVariable("document") Long document) {
    Customer customer =  customerService.findByDocument(document);
    if (null == customer) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(customer);
  }

  /**
   * * Ignore try block, but keep catch and finally blocks.
   *
   * @param id asdasd
   * @param customer asdasd
   * @return CustomerList asdasdsa
   */
  @PutMapping(value = "/{id}")
  public ResponseEntity<Customer> updateCustomer(
          @PathVariable("id") Long id,
          @RequestBody Customer customer) {
    customer.setId(id);
    Customer customerUpdate =  customerService.updateCustomer(customer);
    if (null == customer) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(customerUpdate);
  }

  /**
   * * Ignore try block, but keep catch and finally blocks.
   *
   * @param id asdasd
   * @return CustomerList asdasdsa
   */
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Customer> deleteProduct(@PathVariable("id") Long id) {
    Customer customer =  customerService.deleteCustomer(id);
    if (null == customer) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(customer);
  }
}
