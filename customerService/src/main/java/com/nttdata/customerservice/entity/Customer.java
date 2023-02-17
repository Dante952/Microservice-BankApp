package com.nttdata.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity of the Customer object that defines all its attributes.
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
  @NotEmpty(message = "the document must not be empty")
  @Size(min = 8, max = 8, message = "the document size is 8 characters")
  private String  document;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "documenttype_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private DocumentType documentType;
  @NotEmpty(message = "the name must not be empty")
  private String name;
  @NotEmpty(message = "the status must not be empty")
  private String status;

  @Size(min = 9, max = 9, message = "the document size is 8 characters")
  private String phoneNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customertype_id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private CustomerType customerType;
}
