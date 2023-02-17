package com.nttdata.creditservice.repository;


import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository with search functions for transactions.
 *
 */
@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Long> {
  public List<Transaction> findByCredit(Credit credit);

}
