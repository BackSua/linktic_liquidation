package com.linktic.linktic_test.infrastructure.output.persistence.repository;

import com.linktic.linktic_test.infrastructure.output.persistence.entity.PremiumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremiumRepository extends JpaRepository<PremiumEntity,Long> {

    @Query("SELECT p FROM PremiumEntity p WHERE :age BETWEEN p.minimumAge AND p.maximumAge")
    List<PremiumEntity> findPremiumsByAge(@Param("age") int age);
}
