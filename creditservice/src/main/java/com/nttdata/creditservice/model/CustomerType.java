package com.nttdata.creditservice.model;

import lombok.Data;

/**
 * * Class representing the type of customer as business or personal.
 *
 */
@Data
public class CustomerType {
  private long id;
  private String name;
  private String description;
}
