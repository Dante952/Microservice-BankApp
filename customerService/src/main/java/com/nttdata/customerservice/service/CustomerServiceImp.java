package com.nttdata.customerservice.service;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import com.nttdata.customerservice.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * Implementation of a Customer contains its basic CRUD functions.
 *
 */

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

  private final CustomerRepository customerRepository;

  /**
   * look for a Customer by their Id.
   *
   * @param id unique customer identifier
   * @return Customer
   */
  @Override
  public Customer getCustomer(Long id) {

    return customerRepository.findById(id).orElse(null);
  }

  /**
   * Create a new Customer.
   *
   * @param customer customer object with all its attributes
   * @return Customer
   */
  @Override
  public Customer createCustomer(Customer customer) {

    return customerRepository.save(customer);
  }

  /**
   * Update an existing Customer.
   *
   * @param customer customer object with all its attributes
   * @return Customer
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
   * Delete an existing Customer.
   *
   * @param id unique customer identifier
   * @return Customer
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
   * Gets all Customers.
   *
   * @return ListCustomer
   */
  @Override
  public List<Customer> listAllCustomer() {

    return customerRepository.findAll();
  }

  /**
   * Search for a customer by their customer type.
   *
   * @param customerType type of client with which the banking system works
   * @return ListCustomer
   */
  @Override
  public List<Customer> findByCustomerType(CustomerType customerType) {
    return customerRepository.findByCustomerType(customerType);
  }

  /**
   * Search for a customer by their identity document.
   *
   * @param document Identity document of a Customer
   * @return ListCustomer
   */
  @Override
  public Customer findByDocument(String document) {
    return customerRepository.findByDocument(document);
  }
}
