package com.nttdata.accountservice.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nttdata.accountservice.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * *Entity about account
 *
 */
@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Float amount;
    @Transient
    private Customer customer;
    private Long idCustomer;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_type_account_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TypeAccountEntity idTypeAccount;

}
