package com.nttdata.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Service that acts as a connection interface between a microservice
 * and its configuration hosted in a git repository.
 *
 * @author Patricio Dante Torres Martínez
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(RegistryServiceApplication.class, args);
  }

}
