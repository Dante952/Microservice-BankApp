package com.nttdata.customerservice.service;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import com.nttdata.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * .
 *
 */

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

  private final CustomerRepository customerRepository;

  /**
   * Ignore try block, but keep catch and finally blocks.
   *
   * @param id String to parse
   * @return A positive integer
   */
  @Override
  public Customer getCustomer(Long id) {

    return customerRepository.findById(id).orElse(null);
  }

  /**
   * Ignore try block, but keep catch and finally blocks.
   *
   * @param customer String to parse
   * @return A positive integer
   */
  @Override
  public Customer createCustomer(Customer customer) {

    return customerRepository.save(customer);
  }

  /**
   * Ignore try block, but keep catch and finally blocks.
   *
   * @param customer String to parse
   * @return A positive integer
   */
  @Override
  public Customer updateCustomer(Customer customer) {
    Customer customerDB = getCustomer(customer.getId());
    if(Optional.ofNullable(customerDB).isEmpty()){
      return null;
    }
    customerDB.setName(customer.getName());
    customerDB.setDocument(customer.getDocument());
    customerDB.setDocumentType(customer.getDocumentType());
    customerDB.setPhoneNumber(customer.getPhoneNumber());
    customerDB.setCustomerType(customer.getCustomerType());
    customerDB.setStatus(customer.getStatus());
    return customerRepository.save(customerDB);

  }

  /**
   * Ignore try block, but keep catch and finally blocks.
   *
   * @param id String to parse
   */
  @Override
  public Customer deleteCustomer(long id) {
    Customer customerDB = getCustomer(id);
    if(Optional.ofNullable(customerDB).isEmpty()){
      return null;
    }
    customerDB.setStatus("DELETE");
    return customerRepository.save(customerDB);

  }

  /**
   * Ignore try block, but keep catch and finally blocks.
   *
   * @return A positive integer
   */
  @Override
  public List<Customer> listAllCustomer() {

    return customerRepository.findAll();
  }

  /**
   * Ignore try block, but keep catch and finally blocks.
   *
   * @param customerType String to parse
   * @return A positive integer
   */
  @Override
  public List<Customer> findByCustomerType(CustomerType customerType) {
    return customerRepository.findByCustomerType(customerType);
  }

  /**
   * * Ignore try block, but keep catch and finally blocks.
   *
   * @param document
   * @return
   */
  @Override
  public Customer findByDocument(long document) {
    return customerRepository.findByDocument(document);
  }
}
