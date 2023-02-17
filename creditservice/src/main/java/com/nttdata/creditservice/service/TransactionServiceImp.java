package com.nttdata.creditservice.service;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.Transaction;
import com.nttdata.creditservice.repository.TransactionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * implementation of the basic functions of a transaction.
 *
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService {
  private final TransactionRepository transactionRepository;

  /**
   * * Get a transaction for your id.
   *
   * @param id unique identifier of a transaction
   * @return Transaction
   */
  @Override
  public Transaction getTransaction(Long id) {
    return transactionRepository.findById(id).orElse(null);
  }

  /**
   * * List of all transactions.
   *
   * @return TransactionList
   */
  @Override
  public List<Transaction> listAllTransaction() {
    return transactionRepository.findAll();
  }

  /**
   * * Get a transaction for your credit.
   *
   * @param credit unique identifier of a transaction
   * @return TransactionList
   */
  @Override
  public List<Transaction> findByCredit(Credit credit) {
    return transactionRepository.findByCredit(credit);
  }

  /**
   * * Get a transaction for your id.
   *
   * @param transaction transaction object with all its attributes
   * @return Transaction
   */
  @Override
  public Transaction createTrasaction(Transaction transaction) {
    return transactionRepository.save(transaction);
  }
}
