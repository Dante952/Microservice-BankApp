package com.nttdata.accountservice.controller;

import java.util.List;
import com.nttdata.accountservice.entity.AccountEntity;
import com.nttdata.accountservice.entity.AuthorizedEntity;
import com.nttdata.accountservice.entity.CustomerEntity;
import com.nttdata.accountservice.entity.MovementEntity;
import com.nttdata.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Some javadoc.
 *
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    AccountService accountServiceController;

    /**
     * Some javadoc.
     *
     */
    @GetMapping(value = "/list")
    public ResponseEntity<List<AccountEntity>> list() {
        List<AccountEntity> accountEntities = accountServiceController.list();
        if (accountEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accountEntities);
    }

    /**
     * Some javadoc.
     *
     */
    @GetMapping(value = "/list/account/{id}")//id costumer
    public ResponseEntity<List<AccountEntity>> getListAccountOfCustomer(@PathVariable("id") Long id) {
        List<AccountEntity> accountEntity = accountServiceController.findCustomerId(CustomerEntity.builder().id(id).build());
        if (null == accountEntity) {
            return ResponseEntity.notFound().build();
        }
        List<AccountEntity> accountEntities = accountServiceController.getListAccountOfCustomer(id);
        if (accountEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accountEntities);
    }

    /**
     * Some javadoc.
     *
     */
    @GetMapping(value = "/list/movement/{id}")//id account
    public ResponseEntity<List<MovementEntity>> getListMovementAccountOfCustomer(@PathVariable("id") Long id) {

        AccountEntity accountEntity = accountServiceController.findAccountId(id);
        if (null == accountEntity) {
            return ResponseEntity.notFound().build();
        }
        List<MovementEntity> movementEntities = accountServiceController.getListMovementAccountOfCustomer(id);
        if (movementEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movementEntities);
    }

    /**
     * Some javadoc.
     *
     */
    @PostMapping(value = "/movement")
    public ResponseEntity<MovementEntity> setDepositCustomer(@RequestBody MovementEntity movementEntity){
        AccountEntity accountEntity = accountServiceController.findAccountId(movementEntity.getIdAccount().getId());
        if (null == accountEntity) {
            return ResponseEntity.notFound().build();
        }
        MovementEntity movement = accountServiceController.setMovementAccountOfCustomer(movementEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(movement);
    }

    /**
     * Some javadoc.
     *
     */
    @PostMapping(value = "/create")
    public ResponseEntity<AccountEntity> save(@RequestBody AccountEntity accountEntity){
        AccountEntity account = accountServiceController.createAccount(accountEntity);
        if (account == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(account);

    }

    /**
     * Some javadoc.
     *
     */
    @PostMapping(value = "/create/authorized")
    public ResponseEntity<AuthorizedEntity> save(@RequestBody AuthorizedEntity authorizedEntity){
        AuthorizedEntity authorized = accountServiceController.createAuthorized(authorizedEntity);
        if (authorized == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(authorized);
    }

}
