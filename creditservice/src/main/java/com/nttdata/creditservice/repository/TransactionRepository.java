package com.nttdata.creditservice.repository;


import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Long> {
    public List<Transaction> findByCredit (Credit credit);

}
