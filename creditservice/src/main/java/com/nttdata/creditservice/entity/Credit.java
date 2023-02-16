package com.nttdata.creditservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_credit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creditType_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CreditType creditType;
    private long customer_id;
    @NotEmpty(message = "the amountMax must not be empty")
    private String amountMax;

    





}

