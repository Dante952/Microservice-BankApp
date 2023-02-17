package com.nttdata.creditservice.service;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.CreditType;

import java.util.List;

public interface CreditService {
    public Credit getCredit(Long id);
    public Credit createCredit(Credit credit);
    public Credit updateCredit(Credit credit);
    public Credit deleteCredit(Long id);
    public List<Credit> listAllCredit();
    public List<Credit> findByCreditType(CreditType creditTypeType);



}
