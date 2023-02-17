package com.nttdata.gateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Service that acts as a connection interface between microservices.
 *
 * @author Patricio Dante Torres Martínez
 */

@EnableEurekaClient
@SpringBootApplication
public class GateserviceApplication {
  public static void main(String[] args) {
    SpringApplication.run(GateserviceApplication.class, args);
  }

}
