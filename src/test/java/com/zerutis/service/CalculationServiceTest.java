package com.zerutis.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {

    @InjectMocks
    private CalculationService service;

    @Test
    @DisplayName("Test Should Pass BigDecimal Calculations Are Correct")
    void shouldCalculateTotalTaxMultiplyingTwoList() {
        assertEquals(new BigDecimal(24).setScale(2, RoundingMode.HALF_EVEN),
                service.calculateTotalTax(
                        Arrays.asList(new BigDecimal(10.0), new BigDecimal(100.0)),
                        Arrays.asList(new BigDecimal(0.9), new BigDecimal(0.15)))
        );
        assertEquals(new BigDecimal(17.4405).setScale(2, RoundingMode.HALF_EVEN),
                service.calculateTotalTax(
                        Arrays.asList(new BigDecimal(0.9), new BigDecimal(0.165)),
                        Arrays.asList(new BigDecimal(15.4), new BigDecimal(21.7)))
        );
        assertEquals(new BigDecimal(0).setScale(2, RoundingMode.HALF_EVEN),
                service.calculateTotalTax(Arrays.asList(),Arrays.asList()));
    }
}