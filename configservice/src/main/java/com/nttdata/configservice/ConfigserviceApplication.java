package com.nttdata.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Service that acts as a connection interface between a microservice
 * and its configuration hosted in a git repository.
 *
 * @author Patricio Dante Torres Martínez
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfigserviceApplication.class, args);
  }

}
