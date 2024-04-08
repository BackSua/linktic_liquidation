package com.linktic.linktic_test.infrastructure.input.rest;

import com.linktic.linktic_test.application.port.input.IInsuredService;
import com.linktic.linktic_test.infrastructure.input.rest.mapper.InsuredRestMapper;
import com.linktic.linktic_test.infrastructure.input.rest.model.request.InsuredRequestDto;
import com.linktic.linktic_test.infrastructure.input.rest.model.response.LiquidationResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/secured")
@RequiredArgsConstructor
@Api(value = "Insured API" , description = "This API allows you to calculate the value of your settlement using the insured's data.")
public class LiquidationRestAdapter {

    private final IInsuredService insuredService;
    private final InsuredRestMapper insuredRestMapper;


    @PostMapping("/calculateLiquidation")
    @ApiOperation(value = "calculate liquidation", httpMethod = "POST")
    public ResponseEntity<?> calculateLiquidation(@ApiParam(value = "Insured data", required = true) @Valid @RequestBody InsuredRequestDto insuredRequestDto) {
        try {
            LiquidationResponseDto liquidation = insuredRestMapper.toLiquidationResponse(insuredService.calculateLiquidation(insuredRestMapper.toInsured(insuredRequestDto)));
            return new ResponseEntity<>(liquidation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
