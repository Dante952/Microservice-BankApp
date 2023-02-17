package com.nttdata.creditservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.creditservice.client.CustomerClient;
import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.CreditType;
import com.nttdata.creditservice.service.CreditService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * * Generates the mapping of the REST APIs for the Credit service.
 *
 */
@RestController
@RequestMapping(value = "/credits")
public class CreditController {

  /**
   * * formatMessage is a function that is responsible for creating a list of errors
   * that facilitates the validation of the Request Body.
   *
   * @param result is the data that contains the error of the function
   * @return String returns a String with the error that occurred
   */
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

  /**
   * * http get function, allows to return the complete list of credits
   * or filtered by their type of credit.
   *
   * @param creditTypeId Identifier of the type of credit that is made in the banking institution
   * @return CreditListJSON
   */
  @GetMapping
  public ResponseEntity<List<Credit>> listCredit(
        @RequestParam(name = "creditId", required = false) Long creditTypeId) {
    List<Credit> credits;
    if (Optional.ofNullable(creditTypeId).isEmpty()) {
      credits = creditService.listAllCredit();
    } else {
      credits = creditService.findByCreditType(
                    CreditType.builder()
                            .id(creditTypeId)
                            .build());
    }
    return ResponseEntity.ok(credits);
  }

  /**
   * * Function http post, is responsible for creating a new credit,
   * whether business or personal.
   *
   * @param credit Credit with the attributes to be created
   * @param result contains the result of a validation and contains errors that may have occurred
   * @return CreditCreatedJSON
   */
  @PostMapping
  public ResponseEntity<Credit> createCredit(
            @Valid @RequestBody Credit credit,
            BindingResult result) {
    if (result.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
    }
    credit.setCustomer(customerClient.getCustomer(credit.getCustomer().getDocument()).getBody());
    credit.setCustomerId(credit.getCustomer().getId());
    Credit creditCreate =  creditService.createCredit(credit);
    return ResponseEntity.status(HttpStatus.CREATED).body(creditCreate);
  }
}
