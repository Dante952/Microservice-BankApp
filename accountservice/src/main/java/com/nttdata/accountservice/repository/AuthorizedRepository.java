package com.nttdata.accountservice.repository;

import com.nttdata.accountservice.entity.AuthorizedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Some javadoc.
 *
 */
@Repository
public interface AuthorizedRepository extends JpaRepository<AuthorizedEntity, Long> {

}
