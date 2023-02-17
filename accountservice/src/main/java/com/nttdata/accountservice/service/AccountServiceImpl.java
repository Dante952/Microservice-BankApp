package com.nttdata.accountservice.service;

import com.nttdata.accountservice.entity.AccountEntity;
import com.nttdata.accountservice.entity.AuthorizedEntity;
import com.nttdata.accountservice.entity.CustomerEntity;
import com.nttdata.accountservice.entity.MovementEntity;
import com.nttdata.accountservice.repository.AccountRepository;
import com.nttdata.accountservice.repository.AuthorizedRepository;
import com.nttdata.accountservice.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MovementRepository movementRepository;

    @Autowired
    AuthorizedRepository authorizedRepository;

    public List<AccountEntity> list() { return accountRepository.findAll();}

    @Override
    public List<AccountEntity> getListAccountOfCustomer(Long id) {
        List<AccountEntity> accountEntity = accountRepository.findAll();


        List<AccountEntity> accountCustomer = accountEntity.stream()
                .filter(accountEntity1 -> Objects.equals(accountEntity1.getIdCustomer().getId(), id))
                .collect(Collectors.toList());
        return  accountCustomer;
    }

    @Override
    public List<MovementEntity> getListMovementAccountOfCustomer(Long id) {
        if (accountRepository.findById(id).isEmpty()){
            return null;
        }
        List<MovementEntity> movementEntities = movementRepository.findAll();
        List<MovementEntity> movementEntity = movementEntities.stream()
                .filter(movementEntity1 -> Objects.equals(movementEntity1.getIdAccount().getId(), id))
                .collect(Collectors.toList());

        return movementEntity;
    }

    @Override
    public MovementEntity setMovementAccountOfCustomer(MovementEntity movementEntity) {
        List<AccountEntity> accountEntity = accountRepository.findAll();

        Optional<AccountEntity> accountCustomer = accountEntity.stream()
                .filter(accountEntity1 -> Objects.equals(accountEntity1.getId(), movementEntity.getIdAccount().getId()))
                .findFirst();

        if (accountCustomer.isEmpty()) {
            return null;
        }
        AccountEntity account = accountCustomer.orElseThrow();
        Float actual = account.getAmount();
        if (movementEntity.getIdType().getId() == 111) {
            actual = actual + movementEntity.getAmount();
        } else {
            if (actual < movementEntity.getAmount()) {
                return null;
            }
            actual = actual - movementEntity.getAmount();
        }

        account.setAmount(actual);
        accountRepository.save(account);

        return movementRepository.save(movementEntity);
    }

    @Override
    public AccountEntity createAccount(AccountEntity accountEntity) {

        Long tipo = accountEntity.getIdTypeAccount().getId();
        CustomerEntity customerEntity = new CustomerEntity() ;
        customerEntity.setId(accountEntity.getIdCustomer().getId());

        if (tipo == 100) {
            return createAccountSaving(accountEntity,customerEntity);
        } else if (tipo == 200) {
            return createAccountCurrent(accountEntity,customerEntity);
        } else if (tipo == 300) {
            return createAccountFixedTerm(accountEntity);
        }else return null;
    }

    @Override
    public AuthorizedEntity createAuthorized(AuthorizedEntity authorizedEntity) {
        AccountEntity account = findAccountId(authorizedEntity.getIdAccount().getId());
        if (account == null) {
            return null;
        }
        return authorizedRepository.save(authorizedEntity);
    }

    @Override
    public AccountEntity findAccountId(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public List<AccountEntity> findCustomerId(CustomerEntity customerEntity) {
        return accountRepository.findByIdCustomer(customerEntity);
    }

    public AccountEntity createAccountSaving(AccountEntity accountEntity,CustomerEntity customerEntity) {

        List<AccountEntity> accountEntities = findCustomerId(customerEntity);
        if (accountEntities.isEmpty() && accountEntity.getIdCustomer().getType().equals("PERSONAL")) {
            return accountRepository.save(accountEntity);
        }
        Long count = accountEntities.stream()
                .filter(accountEntity1 -> accountEntity1.getIdTypeAccount().getType().equals("SAVING"))
                .count();
        if (count < 1 && accountEntity.getIdCustomer().getType().equals("PERSONAL")) {
            return accountRepository.save(accountEntity);
        }
        return null;
    }

    public AccountEntity createAccountCurrent(AccountEntity accountEntity,CustomerEntity customerEntity) {

        List<AccountEntity> accounts = findCustomerId(customerEntity);
        if (accounts.isEmpty() && accountEntity.getIdCustomer().getType().equals("PERSONAL")) {
            return accountRepository.save(accountEntity);
        }
        Long count = accounts.stream()
                .filter(accountEntity1 -> accountEntity1.getIdTypeAccount().getId()==200)
                .count();
        if (count < 1 && accountEntity.getIdCustomer().getType().equals("PERSONAL")) {
            return accountRepository.save(accountEntity);
        }
        else if (accountEntity.getIdCustomer().getType().equals("BUSINESS")) {
            return accountRepository.save(accountEntity);
        }else return null;
    }

    public AccountEntity createAccountFixedTerm(AccountEntity accountEntity) {

        if(accountEntity.getIdCustomer().getType().equals("PERSONAL")) {
                return accountRepository.save(accountEntity);
        }
        return null;
    }

}
