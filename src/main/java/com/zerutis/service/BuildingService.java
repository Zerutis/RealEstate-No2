package com.zerutis.service;

import com.zerutis.dao.BuildingRepo;
import com.zerutis.dao.OwnerRepo;
import com.zerutis.dao.PropertyRepo;
import com.zerutis.exception.ResourceAlreadyExistException;
import com.zerutis.exception.ResourceNotFoundException;
import com.zerutis.model.Building;
import com.zerutis.model.Owner;
import com.zerutis.model.Property;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingService {
    private final BuildingRepo buildingRepo;
    private final OwnerRepo ownerRepo;
    private final PropertyRepo propertyRepo;

    public Building addBuilding(Building building, int ownerId, int propertyId)
    {
        Owner owner = ownerRepo.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner By ID: " + ownerId + " Not Found"));
        Property property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property By ID: " + propertyId + " Not Found"));
        if (buildingRepo.existsById(building.getId()))
            throw new ResourceAlreadyExistException("Building By ID: " + building.getId() + " Already Exists");
        building.setOwner(owner);
        building.setProperty(property);
        return buildingRepo.save(building);
    }

    public Building updateBuilding(Building building, int ownerId, int propertyId) {
        Owner owner = ownerRepo.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner By ID: " + ownerId + " Not Found"));
        Property property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property By ID: " + propertyId + " Not Found"));
        building.setOwner(owner);
        building.setProperty(property);
        return buildingRepo.save(building);
    }

    public String deleteBuilding(int id) {
        if(buildingRepo.existsById(id))
            buildingRepo.delete(buildingRepo.getOne(id));
        else
            throw new ResourceNotFoundException("Building By ID: " + id + " Not Found");
        return "Building Deleted Successfully";
    }

    public List<Building> getBuildings(){
        return buildingRepo.findAll();
    }

    public Building getBuildingById(int id) {
        return buildingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Building By ID: " + id + " Not Found"));
    }
}
