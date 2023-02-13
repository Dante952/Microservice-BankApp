package com.nttdata.customerservice;

import com.nttdata.customerservice.entity.Customer;
import com.nttdata.customerservice.entity.CustomerType;
import com.nttdata.customerservice.entity.DocumentType;
import com.nttdata.customerservice.repository.CustomerRepository;
import com.nttdata.customerservice.service.CustomerService;
import com.nttdata.customerservice.service.CustomerServiceImp;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CustomerServiceMockTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImp(customerRepository);
        Customer customer = Customer.builder()
                .name("Dante")
                .document(73080749)
                .documentType(DocumentType.builder().name("prueba").build())
                .customerType(CustomerType.builder().name("prueba").build())
                .phoneNumber(930220457)
                .status("activo")
                .build();
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));
    }
    @Test
    public void whenValidGetID_thenReturnCustomer(){
        Customer found = customerService.getCustomer(1L);
        Assertions.assertThat(found.getName()).isEqualTo("Dante");
    }
}
