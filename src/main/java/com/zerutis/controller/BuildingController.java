package com.zerutis.controller;

import com.zerutis.model.Building;
import com.zerutis.service.BuildingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
@AllArgsConstructor
public class BuildingController
{
    private final BuildingService buildingService;

    @PostMapping("/{owner_id}/{property_id}")
    public Building addBuilding(
            @RequestBody Building building,
            @PathVariable("owner_id") int ownerId,
            @PathVariable("property_id") int propertyId)
    {
        return buildingService.addBuilding(building, ownerId, propertyId);
    }

    @PutMapping("/{owner_id}/{property_id}")
    public Building updateBuilding(
            @RequestBody Building building,
            @PathVariable("owner_id") int ownerId,
            @PathVariable("property_id") int propertyId)
    {
        return buildingService.updateBuilding(building, ownerId, propertyId);
    }

    @DeleteMapping("/{id}")
    public String deleteBuilding(@PathVariable("id") int id)
    {
        return buildingService.deleteBuilding(id);
    }

    @GetMapping("/all")
    public List<Building> getBuildings() { return buildingService.getBuildings(); }

    @GetMapping("/{id}")
    public Building getBuilding(@PathVariable("id") int id)
    {
        return buildingService.getBuildingById(id);
    }

}
