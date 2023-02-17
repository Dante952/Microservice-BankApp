package com.nttdata.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Customer microservice has its own database and allows the management of this.
 *
 * @author Patricio Dante Torres Martínez
 */

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(CustomerServiceApplication.class, args);
  }

}
