package com.nttdata.creditservice.service;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction getTransaction(Long id);
    public List<Transaction> listAllTransaction();
    public List<Transaction> findByCredit(Credit Credit);
    public Transaction createTrasaction(Transaction transaction);
}
