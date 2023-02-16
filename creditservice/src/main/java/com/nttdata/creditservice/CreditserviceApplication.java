package com.nttdata.creditservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CreditserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditserviceApplication.class, args);
	}

}
