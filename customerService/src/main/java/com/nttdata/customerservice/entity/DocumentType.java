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
 * Entity that indicates the types of documents that are accepted for a client,
 * each one linked to an id: DNI - 0, passport - 1, RUC - 2.
 *
 */

@Entity
@Table(name = "tbl_documenttype")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String description;
}
