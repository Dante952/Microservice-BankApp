package com.nttdata.accountservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * *Type of Authorized about account
 *
 */
@Entity
@Table(name = "type_authorized")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeAuthorizedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
}
