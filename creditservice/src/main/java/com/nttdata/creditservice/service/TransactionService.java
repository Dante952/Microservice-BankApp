package com.nttdata.creditservice.service;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.Transaction;
import java.util.List;

/**
 * Service of the basic functions of a transaction.
 *
 */
public interface TransactionService {

  /**
   * * Get a transaction for your id.
   *
   * @param id unique identifier of a transaction
   * @return Transaction
   */
  public Transaction getTransaction(Long id);

  /**
   * * List of all transactions.
   *
   * @return TransactionList
   */
  public List<Transaction> listAllTransaction();

  /**
   * * Get a transaction for your credit.
   *
   * @param credit unique identifier of a transaction
   * @return TransactionList
   */
  public List<Transaction> findByCredit(Credit credit);

  /**
   * * Get a transaction for your id.
   *
   * @param transaction transaction object with all its attributes
   * @return Transaction
   */
  public Transaction createTrasaction(Transaction transaction);
}
