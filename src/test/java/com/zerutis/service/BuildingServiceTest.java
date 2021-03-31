package com.zerutis.service;

import com.zerutis.dao.BuildingRepo;
import com.zerutis.dao.OwnerRepo;
import com.zerutis.dao.PropertyRepo;
import com.zerutis.model.Building;
import com.zerutis.model.Owner;
import com.zerutis.model.Property;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
class BuildingServiceTest {

    @Mock
    private BuildingRepo buildingRepo;

    @Mock
    private OwnerRepo ownerRepo;

    @Mock
    private PropertyRepo propertyRepo;

    @InjectMocks
    BuildingService service;


    @Test
    @DisplayName("Test Should Pass When Repository Method Save Is Called 1 Time")
    void shouldAddBuilding() {
        Building building = new Building(1,null, null,"Vilnius","Taikos",7,2.2,null);
        when(ownerRepo.findById(1)).thenReturn(Optional.of(new Owner()));
        when(propertyRepo.findById(1)).thenReturn(Optional.of(new Property()));
        when(buildingRepo.existsById(1)).thenReturn(false);

        service.addBuilding(building,1,1);

        verify(buildingRepo, times(1)).save(any(Building.class));
    }

    @Test
    @DisplayName("Test Should Pass When City Names Are Different")
    void shouldUpdateBuilding() {
        Building building = new Building(1,null, null,"Vilnius","Taikos",7,2.2,null);
        Building updatedBuilding = new Building(1,null, null,"Kaunas","Taikos",7,2.2,null);
        when(ownerRepo.findById(1)).thenReturn(Optional.of(new Owner()));
        when(propertyRepo.findById(1)).thenReturn(Optional.of(new Property()));
        when(buildingRepo.save(building)).thenReturn(updatedBuilding);

        assertNotEquals(building.getCity(),service.updateBuilding(building,1,1).getCity());
    }

    @Test
    @DisplayName("Test Should Pass When Repository Method Delete Is Called 1 Time")
    void shouldDeleteBuilding() {
        when(buildingRepo.existsById(1)).thenReturn(true);
        when(buildingRepo.getOne(1)).thenReturn(new Building()).thenReturn(null);
        service.deleteBuilding(1);

        verify(buildingRepo, times(1)).delete(any(Building.class));
    }

    @Test
    @DisplayName("Test Should Pass When All The Given Buildings Are Retrieved")
    void shouldGetAllTheBuildings() {
        List<Building> expectedList = Arrays.asList(
                new Building(1,null, null,"Vilnius","Taikos",7,2.2,null),
                new Building(2,null, null,"Kaunas","Laisvės",14,1.8,null)
        );
        when(buildingRepo.findAll()).thenReturn(expectedList);
        List<Building> actualList = service.getBuildings();

        assertEquals(2,actualList.size());
        assertEquals(expectedList,actualList);
        verify(buildingRepo, times(1)).findAll();
    }

    @Test
    @DisplayName("Test Should Pass When Retrieved Building By Id Is The Same As Expected")
    void shouldFindBuildingById(){
        Building expectedBuilding = new Building(1,null, null,"Vilnius","Taikos",7,2.2,null);
        when(buildingRepo.findById(1)).thenReturn(Optional.of(expectedBuilding));
        Building actualBuilding = service.getBuildingById(1);

        assertEquals(actualBuilding,expectedBuilding);
        assertEquals(actualBuilding.getId(),expectedBuilding.getId());
        verify(buildingRepo,times(1)).findById(1);
    }
}