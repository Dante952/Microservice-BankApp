package com.nttdata.customerservice.service;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import java.util.List;

/**
 * .
 *
 */

public interface CustomerService {
  public Customer getCustomer(Long id);

  public Customer createCustomer(Customer customer);

  public Customer updateCustomer(Customer customer);

  public Customer deleteCustomer(long id);

  public List<Customer> listAllCustomer();

  public List<Customer> findByCustomerType(CustomerType customerType);

  public Customer findByDocument(long document);


}
