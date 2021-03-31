package com.zerutis.controller;

import com.zerutis.model.Owner;
import com.zerutis.service.CalculationService;
import com.zerutis.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(("/owner"))
@AllArgsConstructor
public class OwnerController {

    private final CalculationService calculationService;
    private final OwnerService ownerService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Owner addOwner(@RequestBody Owner owner) { return ownerService.addOwner(owner); }

    @PutMapping
    public Owner updateOwner(@RequestBody Owner owner)
    {
        return ownerService.updateOwner(owner);
    }

    @DeleteMapping("/{id}")
    public String deleteOwner(@PathVariable("id") int id)
    {
        return ownerService.deleteOwner(id);
    }

    @GetMapping("/all")
    public List<Owner> getOwners()
    {
        return ownerService.getOwners();
    }

    @GetMapping("/{id}")
    public Owner getOwner(@PathVariable("id") int id)
    {
        return ownerService.getOwnerById(id);
    }

    @GetMapping("/tax")
    public BigDecimal getOwnerTax(@RequestParam("id") int id) {
        return calculationService.getTotalTax(id);
    }

}
