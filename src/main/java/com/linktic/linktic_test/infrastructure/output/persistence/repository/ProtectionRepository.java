package com.linktic.linktic_test.infrastructure.output.persistence.repository;

import com.linktic.linktic_test.infrastructure.output.persistence.entity.ProtectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtectionRepository extends JpaRepository<ProtectionEntity,Long> {
}
