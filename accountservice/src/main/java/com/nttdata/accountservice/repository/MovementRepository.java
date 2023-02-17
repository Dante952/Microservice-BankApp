package com.nttdata.accountservice.repository;

import com.nttdata.accountservice.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Some javadoc.
 *
 */
@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {
}
