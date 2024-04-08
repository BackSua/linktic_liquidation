package com.linktic.linktic_test.infrastructure.output.persistence.repository;

import com.linktic.linktic_test.application.service.InsuredService;
import com.linktic.linktic_test.infrastructure.output.persistence.entity.InsuredEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredRepository extends JpaRepository<InsuredEntity,Long> {
}
