package com.nttdata.creditservice.service;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.CreditType;
import java.util.List;


/**
 * * Interface where the basic functions are declared (CRUD).
 *
 */
public interface CreditService {

  /**
   * * obtains a credit searching for it by its id.
   *
   * @param id unique credit identifier
   * @return Credit
   */
  public Credit getCredit(Long id);

  /**
   * * create new credit.
   *
   * @param credit credit object
   * @return Credit
   */
  public Credit createCredit(Credit credit);

  /**
   * * update an existing credit.
   *
   * @param credit credit object
   * @return Credit
   */
  public Credit updateCredit(Credit credit);

  /**
   * * delete an existing credit.
   *
   * @param id unique credit identifier
   * @return Credit
   */
  public Credit deleteCredit(Long id);

  /**
   * * lists all existing credits.
   *
   * @return ListCredits
   */
  public List<Credit> listAllCredit();

  /**
   * * finds all credits that match the type of credit sent.
   *
   * @return ListCredits
   */
  public List<Credit> findByCreditType(CreditType creditTypeType);
}
