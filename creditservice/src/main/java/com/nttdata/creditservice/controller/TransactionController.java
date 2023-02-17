package com.nttdata.creditservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.Transaction;
import com.nttdata.creditservice.service.TransactionService;
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
 * Handler of rest functions in transactions like create pay or charge.
 *
 */
@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

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

  /**
   * Service with CRUD methods.
   *
   */
  @Autowired
  private TransactionService transactionService;

  /**
   * * Search all transactions made.
   *
   * @param creditId unique credit identifier
   * @return TransactionList
   */
  @GetMapping
  public ResponseEntity<List<Transaction>> listTransaction(
            @RequestParam(name = "credit", required = false) Long creditId) {
    List<Transaction> transactions;
    if (Optional.ofNullable(creditId).isEmpty()) {
      transactions = transactionService.listAllTransaction();
    } else {
      transactions = transactionService.findByCredit(
                    Credit.builder()
                            .id(creditId)
                            .build());
    }
    return ResponseEntity.ok(transactions);
  }

  /**
   * * Create a new transaction.
   *
   * @param transaction transaction object with all its attributes
   * @return TransactionList
   */
  @PostMapping
  public ResponseEntity<Transaction> createTransaction(
            @Valid @RequestBody Transaction transaction,
            BindingResult result) {
    if (result.hasErrors()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
    }
    Transaction transactionCreate =  transactionService.createTrasaction(transaction);
    return ResponseEntity.status(HttpStatus.CREATED).body(transactionCreate);
  }
}
