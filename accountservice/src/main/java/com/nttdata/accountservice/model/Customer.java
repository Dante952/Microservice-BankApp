package com.nttdata.accountservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private long id;
    private String  document;
    private DocumentType documentType;
    private String name;
    private String status;
    private String phoneNumber;
    private CustomerType customerType;
}
