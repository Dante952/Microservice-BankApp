package com.nttdata.accountservice.client;

import com.nttdata.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "customerservice", path = "/customers")
public interface CustomerClient {
    @GetMapping(value = "/{document}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("document") String document);

}
