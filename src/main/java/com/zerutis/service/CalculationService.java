package com.zerutis.service;

import com.zerutis.dao.OwnerRepo;
import com.zerutis.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
public class CalculationService
{
    private final OwnerRepo ownerRepo;

    public BigDecimal calculateTotalTax(List<BigDecimal> value, List<BigDecimal> taxRate) {
        int n = value.size();
        if(n > taxRate.size()) {
            n = taxRate.size();
        }
        BigDecimal totalTax = new BigDecimal(0.0);
        for(int i = 0; i < n; i++) {
            totalTax = totalTax.add(value.get(i).multiply(taxRate.get(i), MathContext.DECIMAL32));
        }

        return totalTax.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getTotalTax(int id)
    {
        if(!ownerRepo.existsById(id))
            throw new ResourceNotFoundException("Owner By ID: " + id + " Not Found");
        return calculateTotalTax(ownerRepo.findValueById(id), ownerRepo.findTaxRateById(id));
    }
}
