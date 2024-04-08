package com.linktic.linktic_test.application.service;

import com.linktic.linktic_test.application.constant.MessageConstant;
import com.linktic.linktic_test.application.port.input.IInsuredService;
import com.linktic.linktic_test.application.port.output.IPersistenPort;
import com.linktic.linktic_test.domain.model.Insured;
import com.linktic.linktic_test.domain.model.Liquidation;
import com.linktic.linktic_test.domain.model.Premium;
import com.linktic.linktic_test.domain.model.Protection;
import com.linktic.linktic_test.infrastructure.output.persistence.entity.PremiumEntity;
import com.linktic.linktic_test.infrastructure.output.persistence.entity.ProtectionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InsuredService implements IInsuredService {

    private final IPersistenPort iPersistenPort;

    @Override
    public Liquidation calculateLiquidation(Insured insured) {
        if (insured.getInsuredValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(MessageConstant.VALUE_GREATER_THAN_ZERO);
        }
        Liquidation liquidation = Liquidation.builder()
                .identificationType(insured.getIdentificationType())
                .identificationNumber(insured.getIdentificationNumber())
                .insuredValue(insured.getInsuredValue())
                .liquidation(new ArrayList<>())
                .build();

        BigDecimal totalValue = BigDecimal.ZERO;

        int age = calculateAge(insured.getDateOfBirth());
        List<Premium> applicablePremiums = toModelList(iPersistenPort.premiumList(age));
        for (Premium premium : applicablePremiums) {
            BigDecimal premiumValue = insured.getInsuredValue().multiply(premium.getPremiumPercentage());
            totalValue = totalValue.add(premiumValue);

            Protection protection = toModelProtection(iPersistenPort.findById(premium.getProtectionCode())
                    .orElseThrow(() -> new RuntimeException(MessageConstant.AMPARO_NOT_FOUND)));
            liquidation.getLiquidation().add(new Protection(protection.getProtectionCode(), protection.getProtectionName(), premiumValue));
        }
        liquidation.setTotalValue(totalValue);
        return liquidation;
    }

    private int calculateAge(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    private List<Premium> toModelList(List<PremiumEntity> premiumEntities){
        return premiumEntities.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
    private Premium toModel(PremiumEntity premiumEntity){
        return Premium.builder()
                .protectionCode(premiumEntity.getProtectionCode())
                .maximumAge(premiumEntity.getMaximumAge())
                .minimumAge(premiumEntity.getMinimumAge())
                .premiumPercentage(premiumEntity.getPremiumPercentage())
                .build();
    }

    private Protection toModelProtection(ProtectionEntity protection){
        return Protection.builder()
                .protectionCode(protection.getCode())
                .protectionName(protection.getName())
                .build();
    }
}
