package com.nttdata.creditservice.model;

import lombok.Data;

/**
 * * Class containing the attributes of a customer.
 *
 */
@Data
public class Customer {
  private long id;
  private String  document;
  private DocumentType documentType;
  private String name;
  private String status;
  private String phoneNumber;
  private CustomerType customerType;
}
