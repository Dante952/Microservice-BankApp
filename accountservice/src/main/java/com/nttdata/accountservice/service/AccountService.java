package com.nttdata.accountservice.service;

import com.nttdata.accountservice.entity.AccountEntity;
import com.nttdata.accountservice.entity.AuthorizedEntity;
import com.nttdata.accountservice.entity.MovementEntity;
import com.nttdata.accountservice.model.Customer;

import java.util.List;

public interface AccountService {
  List<AccountEntity> list();
  List<AccountEntity> getListAccountOfCustomer(Long id);

  List<MovementEntity> getListMovementAccountOfCustomer(Long id);

  MovementEntity setMovementAccountOfCustomer(MovementEntity movementEntity);

  AccountEntity createAccount(AccountEntity accountEntity, Customer customer);

  AuthorizedEntity createAuthorized(AuthorizedEntity authorizedEntity);

  AccountEntity findAccountId(Long id);

  List<AccountEntity> findCustomerId(Customer customer);

}
