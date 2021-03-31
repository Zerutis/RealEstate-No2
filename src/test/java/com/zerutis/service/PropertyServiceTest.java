package com.zerutis.service;

import com.zerutis.dao.PropertyRepo;
import com.zerutis.model.Property;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @Mock
    private PropertyRepo propertyRepo;

    @InjectMocks
    PropertyService service;


    @Test
    @DisplayName("Test Should Pass When Repository Method Save Is Called 1 Time")
    void shouldAddProperty() {
        Property property = new Property(1,"Flat",null,null);
        when(propertyRepo.existsById(1)).thenReturn(false);
        service.addProperty(property);

        verify(propertyRepo, times(1)).save(any(Property.class));
    }

    @Test
    @DisplayName("Test Should Pass When Property Types Are Different")
    void shouldUpdateProperty() {
        Property property = new Property(1,"Flat",null,null);
        Property updatedProperty = new Property(1,"House",null,null);
        when(propertyRepo.save(property)).thenReturn(updatedProperty);

        assertNotEquals(property.getPropertyType(),service.updateProperty(property).getPropertyType());
    }

    @Test
    @DisplayName("Test Should Pass When Repository Method Delete Is Called 1 Time")
    void shouldDeleteProperty() {
        when(propertyRepo.existsById(1)).thenReturn(true);
        when(propertyRepo.getOne(1)).thenReturn(new Property()).thenReturn(null);
        service.deleteProperty(1);

        verify(propertyRepo, times(1)).delete(any(Property.class));
    }

    @Test
    @DisplayName("Test Should Pass When All The Given Properties Are Retrieved")
    void shouldGetAllTheProperties() {
        List<Property> expectedList = Arrays.asList(
                new Property(1,"Flat",null,null),
                new Property(2,"Loft",null,null)
        );

        when(propertyRepo.findAll()).thenReturn(expectedList);
        List<Property> actualList = service.getProperties();

        assertEquals(2,actualList.size());
        assertEquals(expectedList,actualList);
        verify(propertyRepo, times(1)).findAll();
    }

    @Test
    @DisplayName("Test Should Pass When Retrieved Property By Id Is The Same As Expected")
    void shouldFindPropertyById(){
        Property expectedProperty = new Property(1,"Flat",null,null);
        when(propertyRepo.findById(1)).thenReturn(Optional.of(expectedProperty));

        Property actualProperty = service.getPropertyById(1);
        assertEquals(actualProperty,expectedProperty);
        assertEquals(actualProperty.getId(),expectedProperty.getId());
        verify(propertyRepo,times(1)).findById(1);
    }
}