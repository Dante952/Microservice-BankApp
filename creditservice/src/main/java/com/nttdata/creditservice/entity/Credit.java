package com.nttdata.creditservice.entity;

import com.fasterxml.jackson.annotation.*;
import com.nttdata.creditservice.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "tbl_credit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="index")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credittype_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CreditType creditType;


    @Transient
    private Customer customer;

    @Column(name = "customer_id")
    private Long customer_id;
    @NotEmpty(message = "the status must not be empty")
    private String status;
    @NotEmpty(message = "the amountMax must not be empty")
    private String amountMax;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;



}

