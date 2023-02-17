package com.nttdata.accountservice.repository;

import java.util.List;
import com.nttdata.accountservice.entity.AccountEntity;
import com.nttdata.accountservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 ** Repository about Accounts
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findByIdCustomer(Long id);

}
