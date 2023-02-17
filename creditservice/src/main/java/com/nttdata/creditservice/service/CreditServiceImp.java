package com.nttdata.creditservice.service;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.CreditType;
import com.nttdata.creditservice.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditServiceImp implements CreditService {


  private final CreditRepository creditRepository;
  /**
   * @param id
   * @return
   */
  @Override
  public Credit getCredit(Long id) {
    return creditRepository.findById(id).orElse(null);
  }

  /**
   * @param credit
   * @return
   */
  @Override
  public Credit createCredit(Credit credit) {
    return creditRepository.save(credit);
  }

  /**
   * @param credit
   * @return
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
   * @param id
   * @return
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
   * @return
   */
  @Override
  public List<Credit> listAllCredit() {
    return creditRepository.findAll();
  }

  /**
   * @param customerType
   * @return
   */
  @Override
  public List<Credit> findByCreditType(CreditType creditType) {
    return creditRepository.findByCreditType(creditType);
  }
}
