package com.nttdata.customerservice;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import com.nttdata.customerservice.entity.DocumentType;
import com.nttdata.customerservice.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CustomerRepositoryMockTest {
  @Autowired
  private CustomerRepository customerRepository;
  @Test
  public void createCustomer(){
      Customer customer = Customer.builder()
              .name("Dante")
              .document(73080749)
              .documentType(DocumentType.builder().name("prueba").build())
              .customerType(CustomerType.builder().name("prueba").build())
              .phoneNumber(930220457)
              .status("activo")
              .build();

      customerRepository.save(customer);

      List<Customer> founds = customerRepository.findByCustomerType(customer.getCustomerType());

      Assertions.assertThat(  founds.size()).isEqualTo(1);

  }

}
