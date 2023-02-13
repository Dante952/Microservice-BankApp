package com.nttdata.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Microservice in charge of managing bank clients, such as business and personal.
 *
 */

@SpringBootApplication
public class CustomerServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(CustomerServiceApplication.class, args);
  }

}
