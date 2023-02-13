package com.nttdata.customerservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Some javadoc.
 *
 */
@Entity
@Table(name = "tbl_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private long  document;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "documenttype_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
  private DocumentType documentType;

  private String name;
  private String status;
  private int phoneNumber;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customertype_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
  private CustomerType customerType;
}
