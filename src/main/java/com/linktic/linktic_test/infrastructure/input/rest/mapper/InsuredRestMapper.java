package com.linktic.linktic_test.infrastructure.input.rest.mapper;

import com.linktic.linktic_test.domain.model.Insured;
import com.linktic.linktic_test.domain.model.Liquidation;
import com.linktic.linktic_test.domain.model.Protection;
import com.linktic.linktic_test.infrastructure.input.rest.model.request.InsuredRequestDto;
import com.linktic.linktic_test.infrastructure.input.rest.model.response.LiquidationResponseDto;
import com.linktic.linktic_test.infrastructure.input.rest.model.response.ProtectionResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InsuredRestMapper {

    public Insured toInsured(InsuredRequestDto insuredRequestDto){
        return Insured.builder()
                .identificationType(insuredRequestDto.getIdentificationType())
                .dateOfBirth(insuredRequestDto.getDateOfBirth())
                .identificationNumber(insuredRequestDto.getIdentificationNumber())
                .insuredValue(insuredRequestDto.getInsuredAmount())
                .build();
    };

    public LiquidationResponseDto toLiquidationResponse(Liquidation liquidation){
        return LiquidationResponseDto.builder()
                .identificationType(liquidation.getIdentificationType())
                .identificationNumber(liquidation.getIdentificationNumber())
                .insuredValue(liquidation.getInsuredValue())
                .liquidation(protectionResponseDtos(liquidation.getLiquidation()))
                .totalValue(liquidation.getTotalValue())
                .build();
    };

    public List<ProtectionResponseDto> protectionResponseDtos(List<Protection> protections){
        return protections.stream()
                .map(this::responseDto)
                .collect(Collectors.toList());
    }

    public ProtectionResponseDto responseDto(Protection protection){
        return ProtectionResponseDto.builder()
                .premiumValue(protection.getPremiumValue())
                .protectionCode(protection.getProtectionCode())
                .protectionName(protection.getProtectionName())
                .build();
    }
}
