package com.nttdata.creditservice.repository;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.CreditType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * * Interface that has a repository of functions that are performed in the credit class.
 *
 */
@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
  public List<Credit> findByCreditType(CreditType creditType);

}
