package com.nttdata.accountservice;

import com.nttdata.accountservice.entity.AccountEntity;
import com.nttdata.accountservice.entity.TypeAccountEntity;
import com.nttdata.accountservice.repository.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;
    @Test
    public void findAllWhenCreate(){
        AccountEntity accountEntity = AccountEntity.builder()
                .id(200L)
                .number("1022700521")
                .amount(1200.10F)
                .idCustomer(CustomerEntity.builder().id(2L).build())
                .idTypeAccount(TypeAccountEntity.builder().id(200L).build())
                .build();
        accountRepository.save(accountEntity);


        List<AccountEntity> founds= accountRepository.findAll();

        Assertions.assertThat(founds.size()).isEqualTo(1);

    }
}
