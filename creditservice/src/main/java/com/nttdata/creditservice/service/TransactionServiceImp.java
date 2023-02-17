package com.nttdata.creditservice.service;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.Transaction;
import com.nttdata.creditservice.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService{

    private final TransactionRepository transactionRepository;
    /**
     * @param id
     * @return
     */
    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    /**
     * @return
     */
    @Override
    public List<Transaction> listAllTransaction() {
        return transactionRepository.findAll();
    }

    /**
     * @return
     */
    @Override
    public List<Transaction> findByCredit(Credit credit) {
        return transactionRepository.findByCredit(credit);
    }

    /**
     * @param transaction
     * @return
     */
    @Override
    public Transaction createTrasaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
