package com.nttdata.customerservice.service;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import java.util.List;

/**
 * Service of a Customer contains its basic functions CRUD.
 *
 */

public interface CustomerService {

  /**
   * look for a Customer by their Id.
   *
   * @param id unique customer identifier
   * @return Customer
   */
  public Customer getCustomer(Long id);

  /**
   * Create a new Customer.
   *
   * @param customer customer object with all its attributes
   * @return Customer
   */
  public Customer createCustomer(Customer customer);

  /**
   * Update an existing Customer.
   *
   * @param customer customer object with all its attributes
   * @return Customer
   */
  public Customer updateCustomer(Customer customer);

  /**
   * Delete an existing Customer.
   *
   * @param id unique customer identifier
   * @return Customer
   */
  public Customer deleteCustomer(long id);

  /**
   * Gets all Customers.
   *
   * @return ListCustomer
   */
  public List<Customer> listAllCustomer();

  /**
   * Search for a customer by their customer type.
   *
   * @param customerType type of client with which the banking system works
   * @return ListCustomer
   */
  public List<Customer> findByCustomerType(CustomerType customerType);

  /**
   * Search for a customer by their identity document.
   *
   * @param document Identity document of a Customer
   * @return ListCustomer
   */
  public Customer findByDocument(String document);
}
