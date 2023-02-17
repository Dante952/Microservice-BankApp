package com.nttdata.accountservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * *Authorized people about an account
 *
 */
@Entity
@Table(name = "authorized")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorizedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TypeAuthorizedEntity idType;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private AccountEntity idAccount;
}
