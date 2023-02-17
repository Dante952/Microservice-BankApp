package com.nttdata.accountservice.repository;

import java.util.List;
import com.nttdata.accountservice.entity.AccountEntity;
import com.nttdata.accountservice.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Some javadoc.
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

  List<AccountEntity> findByIdCustomer(CustomerEntity customerEntity);

}
