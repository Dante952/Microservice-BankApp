package com.nttdata.accountservice.repository;

import com.nttdata.accountservice.entity.AuthorizedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * *Repository about Person Authorized
 *
 */
@Repository
public interface AuthorizedRepository extends JpaRepository<AuthorizedEntity, Long> {

}
