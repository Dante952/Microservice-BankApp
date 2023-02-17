package com.nttdata.accountservice.entity;

import javax.persistence.*;

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
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_customer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private CustomerEntity idCustomer;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_type_account_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private TypeAccountEntity idTypeAccount;

}
