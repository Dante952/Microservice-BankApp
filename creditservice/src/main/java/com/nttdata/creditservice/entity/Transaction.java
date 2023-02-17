package com.nttdata.creditservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "index")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "credit_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Credit credit;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "transactiontype_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private TransactionType transactionType;
  @NotEmpty(message = "the amount must not be empty")
  private String amount;
}
