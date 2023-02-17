package com.nttdata.creditservice.model;

import lombok.Data;

/**
 * * Class representing the type of document as RUC or dni or passaport.
 *
 */
@Data
public class DocumentType {
  private long id;
  private String name;
  private String description;
}
