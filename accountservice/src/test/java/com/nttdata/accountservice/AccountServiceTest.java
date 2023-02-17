package com.nttdata.accountservice;

import com.nttdata.accountservice.entity.AccountEntity;
import com.nttdata.accountservice.entity.MovementEntity;
import com.nttdata.accountservice.repository.AccountRepository;
import com.nttdata.accountservice.service.AccountService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@DataJpaTest
public class AccountServiceTest {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    @Test
    public void whenValidList(){
        List<AccountEntity> accountEntities = accountRepository.findAll();
        List<AccountEntity> accounts = accountEntities.stream()
                .filter(accountEntity -> accountEntity.getIdTypeAccount().getType().equals("SAVING"))
                .filter(accountEntity -> accountEntity.getAmount()>5000)
                .collect(Collectors.toList());

        Assertions.assertThat(accounts.size()).isEqualTo(3);
    }
    @Test
    public void whenValidGetListAccountOfCustomert(){
        List<AccountEntity> found = accountService.getListAccountOfCustomer(1L);
        Assertions.assertThat(found.size()).isEqualTo(1);
    }

    @Test
    public void whenValidListMovementAccountOfCustomer(){
        List<MovementEntity> found = accountService.getListMovementAccountOfCustomer(1L);
        Assertions.assertThat(found.size()).isEqualTo(1);
    }
    @Test
    public void whenValidfindAccountId(){
        AccountEntity found = accountService.findAccountId(1L);
        Assertions.assertThat(found.getId().equals(1L));
    }

}
