package com.linktic.linktic_test.application.port.input;

import com.linktic.linktic_test.domain.model.Insured;
import com.linktic.linktic_test.domain.model.Liquidation;

public interface IInsuredService {
    Liquidation calculateLiquidation(Insured insured);
}
