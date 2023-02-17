package com.nttdata.customerservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import com.nttdata.customerservice.service.CustomerService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



/**
 * * Generates the mapping of the REST APIs for the Customer service.
 *
 */
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

  /**
   * * formatMessage is a function that is responsible for creating a list of errors
   * that facilitates the validation of the Request Body.
   *
   * @param result is the data that contains the error of the function
   * @return String returns a String with the error that occurred
   */
  private String formatMessage(BindingResult result) {
    List<Map<String, String>> errors = result.getFieldErrors().stream()
            .map(err -> {
              Map<String, String> error = new HashMap<>();
              error.put(err.getField(), err.getDefaultMessage());
              return error;
            }).collect(Collectors.toList());

    ErrorMessage errorMessage = ErrorMessage.builder()
            .code("01")
            .message(errors)
            .build();
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "";
    try {
      jsonString = mapper.writeValueAsString(errorMessage);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return jsonString;

  }

  /**
   * Client service that saves create, modify, find, and delete functions.
   */
  @Autowired
  private CustomerService customerService;

  /**
   * * Returns a complete or filtered list of registered customers by their id.
   *
   * @param customerTypeId unique customer identifier
   * @return CustomerList
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
   * * Create a new customer validating each of its attributes.
   *
   * @param customer Customer received in the request
   * @return ResponseEntity
   */
  @PostMapping
  public ResponseEntity<Customer> createCustomer(
          @Valid @RequestBody Customer customer,
          BindingResult result) {
    if (result.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
    }
    Customer customerCreate =  customerService.createCustomer(customer);
    return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
  }

  /**
   * * gets a Customer looking for their identity document.
   *
   * @param document identity document of a person or company
   * @return Customer
   */
  @GetMapping(value = "/{document}")
  public ResponseEntity<Customer> getCustomer(@PathVariable("document") String document) {
    Customer customer =  customerService.findByDocument(document);

    if (Optional.ofNullable(customer).isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(customer);
  }

  /**
   * * modifies an existing Customer.
   *
   * @param id unique identifier of a Customer
   * @param customer customer object with all its attributes
   * @return Customer
   */
  @PutMapping(value = "/{id}")
  public ResponseEntity<Customer> updateCustomer(
          @PathVariable("id") Long id,
          @RequestBody Customer customer,
          BindingResult result) {

    customer.setId(id);
    Customer customerUpdate =  customerService.updateCustomer(customer);
    if (result.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
    }
    return ResponseEntity.status(HttpStatus.OK).body(customerUpdate);

  }

  /**
   * * delete an existing Customer.
   *
   * @param id unique identifier of a Customer
   * @return CustomerList
   */
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
    Customer customer =  customerService.deleteCustomer(id);
    if (Optional.ofNullable(customer).isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(customer);
  }

}
