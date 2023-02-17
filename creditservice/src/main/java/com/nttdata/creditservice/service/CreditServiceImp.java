package com.nttdata.creditservice.service;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.CreditType;
import com.nttdata.creditservice.repository.CreditRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * * Implementation where the basic functions are declared (CRUD).
 *
 */

@Service
@RequiredArgsConstructor
public class CreditServiceImp implements CreditService {
  private final CreditRepository creditRepository;

  /**
   * * obtains a credit searching for it by its id.
   *
   * @param id unique credit identifier
   * @return Credit
   */
  @Override
  public Credit getCredit(Long id) {
    return creditRepository.findById(id).orElse(null);
  }

  /**
   * * create new credit.
   *
   * @param credit credit object
   * @return Credit
   */
  @Override
  public Credit createCredit(Credit credit) {
    return creditRepository.save(credit);
  }

  /**
   * * update an existing credit.
   *
   * @param credit credit object
   * @return Credit
   */
  @Override
  public Credit updateCredit(Credit credit) {
    Credit creditDb = getCredit(credit.getId());
    if (Optional.ofNullable(creditDb).isEmpty()) {
      return null;
    }
    creditDb.setCreditType(credit.getCreditType());
    creditDb.setTransactions(credit.getTransactions());
    creditDb.setAmountMax(credit.getAmountMax());
    return creditDb;
  }

  /**
   * * delete an existing credit.
   *
   * @param id unique credit identifier
   * @return Credit
   */
  @Override
  public Credit deleteCredit(Long id) {
    Credit creditDb = getCredit(id);
    if (Optional.ofNullable(creditDb).isEmpty()) {
      return null;
    }
    creditDb.setStatus("DELETE");
    return creditRepository.save(creditDb);
  }

  /**
   * * lists all existing credits.
   *
   * @return ListCredits
   */
  @Override
  public List<Credit> listAllCredit() {
    return creditRepository.findAll();
  }

  /**
   * * finds all credits that match the type of credit sent.
   *
   * @return ListCredits
   */
  @Override
  public List<Credit> findByCreditType(CreditType creditType) {
    return creditRepository.findByCreditType(creditType);
  }
}
