package com.linktic.linktic_test.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class Liquidation {
    private Long identificationType;
    private String identificationNumber;
    private BigDecimal insuredValue;
    private List<Protection> liquidation;
    private BigDecimal totalValue;
}
