package com.nttdata.creditservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Entity that indicates the types of customer that are accepted for a customer,
 * each one linked to an id: Personal - 0, Business - 1.
 *
 */

@Entity
@Table(name = "tbl_transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CreditType creditType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transactionType_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TransactionType transactionType;

    @NotEmpty(message = "the amount must not be empty")
    private String aumont;


}
