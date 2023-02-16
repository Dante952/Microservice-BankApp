package com.nttdata.customerservice.service;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import com.nttdata.customerservice.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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
    Customer customerDb = getCustomer(customer.getId());
    if (Optional.ofNullable(customerDb).isEmpty()) {
      return null;
    }
    customerDb.setName(customer.getName());
    customerDb.setDocument(customer.getDocument());
    customerDb.setDocumentType(customer.getDocumentType());
    customerDb.setPhoneNumber(customer.getPhoneNumber());
    customerDb.setCustomerType(customer.getCustomerType());
    customerDb.setStatus(customer.getStatus());
    return customerRepository.save(customerDb);

  }

  /**
   * Ignore try block, but keep catch and finally blocks.
   *
   * @param id String to parse
   */
  @Override
  public Customer deleteCustomer(long id) {
    Customer customerDb = getCustomer(id);
    if (Optional.ofNullable(customerDb).isEmpty()) {
      return null;
    }
    customerDb.setStatus("DELETE");
    return customerRepository.save(customerDb);

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
   * @param document asdas
   * @return Customer sadasd
   */
  @Override
  public Customer findByDocument(String document) {
    return customerRepository.findByDocument(document);
  }
}
