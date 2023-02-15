package com.nttdata.customerservice.repository;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Some javadoc.
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  /**
   * * Ignore try block, but keep catch and finally blocks.
   *
   * @param customerType asdas
   * @return CustomerList
   */
  public List<Customer> findByCustomerType(CustomerType customerType);

  /**
   * * Ignore try block, but keep catch and finally blocks.
   *
   * @param document asd
   * @return Customer sadas
   */
  public Customer findByDocument(long document);







}
