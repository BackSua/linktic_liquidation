package com.linktic.linktic_test.domain.model;

import lombok.Builder;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class Insured {

    @NotNull
    private Long identificationType;
    @NotBlank
    private String identificationNumber;
    @NotNull
    private BigDecimal insuredValue;
    private LocalDate dateOfBirth;
}
