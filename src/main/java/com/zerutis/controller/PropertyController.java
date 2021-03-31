package com.zerutis.controller;

import com.zerutis.model.Property;
import com.zerutis.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/property"))
@AllArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping
    public Property addProperty(@RequestBody Property property)
    {
        return propertyService.addProperty(property);
    }

    @PutMapping
    public Property updateProperty(@RequestBody Property property) { return propertyService.updateProperty(property); }

    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable("id") int id)
    {
        return propertyService.deleteProperty(id);
    }

    @GetMapping("/all")
    public List<Property> getProperties()
    {
        return propertyService.getProperties();
    }

    @GetMapping("/{id}")
    public Property getProperty(@PathVariable("id") int id) { return propertyService.getPropertyById(id); }
}