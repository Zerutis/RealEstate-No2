package com.zerutis.service;

import com.zerutis.dao.PropertyRepo;
import com.zerutis.exception.ResourceAlreadyExistException;
import com.zerutis.exception.ResourceNotFoundException;
import com.zerutis.model.Property;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyService {

    private final PropertyRepo propertyRepo;

    public Property addProperty(Property property) {
        if(propertyRepo.existsById(property.getId()))
            throw new ResourceAlreadyExistException("Property By ID: " + property.getId() + " Already Exists");
        return propertyRepo.save(property);
    }

    public Property updateProperty(Property property) {
        return propertyRepo.save(property);
    }

    public String deleteProperty(int id) {
        if(propertyRepo.existsById(id))
            propertyRepo.delete(propertyRepo.getOne(id));
        else
            throw new ResourceNotFoundException("Property By ID: " + id + " Not Found");
        return "Property Deleted Successfully";
    }

    public List<Property> getProperties(){
        return propertyRepo.findAll();
    }

    public Property getPropertyById(int id) {
        return propertyRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property By ID: " + id + " Not Found"));
    }
}
