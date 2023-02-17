package com.nttdata.creditservice.repository;

import com.nttdata.creditservice.entity.Credit;
import com.nttdata.creditservice.entity.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    public List<Credit> findByCreditType(CreditType creditType);

}
