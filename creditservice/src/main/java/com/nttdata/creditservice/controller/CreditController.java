package com.nttdata.creditservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.creditservice.client.CustomerClient;
import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.CreditType;
import com.nttdata.creditservice.model.Customer;
import com.nttdata.creditservice.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * * Generates the mapping of the REST APIs for the Credit service.
 *
 */
@RestController
@RequestMapping(value = "/credits")
public class CreditController {
    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .message(errors)
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @Autowired
    private CreditService creditService;
    @Autowired
    private CustomerClient customerClient;

    @GetMapping
    public ResponseEntity<List<Credit>> listCredit(
            @RequestParam(name = "creditId", required = false) Long creditTypeId) {
        List<Credit> customers;
        if (Optional.ofNullable(creditTypeId).isEmpty()) {
            customers = creditService.listAllCredit();
        } else {
            customers = creditService.findByCreditType(
                    CreditType.builder()
                            .id(creditTypeId)
                            .build());
        }
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Credit> createCredit(
            @Valid @RequestBody Credit credit,
            BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Credit creditCreate =  creditService.createCredit(credit);
        creditCreate.setCustomer((Customer) customerClient.getCustomer(credit.getCustomer().getDocument()).getBody());
        return ResponseEntity.status(HttpStatus.CREATED).body(creditCreate);
    }



}
