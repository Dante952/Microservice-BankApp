package com.nttdata.creditservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity that indicates the types of customer that are accepted for a customer,
 * each one linked to an id: Personal - 0, Business - 1.
 *
 */

@Entity
@Table(name = "tbl_creditType")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
}