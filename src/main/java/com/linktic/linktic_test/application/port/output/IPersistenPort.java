package com.linktic.linktic_test.application.port.output;

import com.linktic.linktic_test.infrastructure.output.persistence.entity.PremiumEntity;
import com.linktic.linktic_test.infrastructure.output.persistence.entity.ProtectionEntity;

import java.util.List;
import java.util.Optional;

public interface IPersistenPort {

    List<PremiumEntity> premiumList(int age);

    Optional<ProtectionEntity> findById(Long id);
}
