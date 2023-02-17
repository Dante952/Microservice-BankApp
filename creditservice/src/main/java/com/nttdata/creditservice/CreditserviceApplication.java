package com.nttdata.creditservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Microservice in charge of managing and managing credit products.
 *
 * @author Patricio Dante Torres Martínez
 */

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class CreditserviceApplication {
  public static void main(String[] args) {
    SpringApplication.run(CreditserviceApplication.class, args);
  }

}
