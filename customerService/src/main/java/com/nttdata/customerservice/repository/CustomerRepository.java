package com.nttdata.customerservice.repository;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Customer repository with its search functions.
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  /**
   * * search for a Customer by its type.
   *
   * @param customerType Type of client can be business or personal.
   * @return CustomerList
   */
  public List<Customer> findByCustomerType(CustomerType customerType);

  /**
   * * Search for a Customer by their identity document.
   *
   * @param document Unique identity document can be passport dni or ruc
   * @return Customer
   */
  public Customer findByDocument(String document);
}
