package com.nttdata.customerservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "tbl_customertype")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String description;
}
