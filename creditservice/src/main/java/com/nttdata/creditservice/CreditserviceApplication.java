package com.nttdata.creditservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Microservice that manages the credits that are requested as business credit, personal credit and credit card
 *
 */

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class CreditserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditserviceApplication.class, args);
	}

}
