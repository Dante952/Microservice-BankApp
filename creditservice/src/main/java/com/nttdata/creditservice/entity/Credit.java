package com.nttdata.creditservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nttdata.creditservice.model.Customer;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * * Credit entity that loads the attributes and relationships required by a credit,
 * be it business or personal.
 *
 */

@Entity
@Table(name = "tbl_credit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "index")
public class Credit {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "credittype_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private CreditType creditType;
  @Transient
  private Customer customer;
  @Column(name = "customer_id")
  private Long customerId;
  @NotEmpty(message = "the status must not be empty")
  private String status;
  @NotEmpty(message = "the amountMax must not be empty")
  private String amountMax;
  @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Transaction> transactions;
}

