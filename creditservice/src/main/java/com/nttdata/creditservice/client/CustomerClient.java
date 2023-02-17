package com.nttdata.creditservice.client;

import com.nttdata.creditservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * * interface requesting customer service.
 *
 */
@FeignClient(name = "customerservice", path = "/customers")
public interface CustomerClient {
  @GetMapping(value = "/{document}")
  public ResponseEntity<Customer> getCustomer(@PathVariable("document") String document);

}
