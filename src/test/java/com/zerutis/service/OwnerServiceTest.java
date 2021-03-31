package com.zerutis.service;

import com.zerutis.dao.OwnerRepo;
import com.zerutis.model.Owner;
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

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @Mock
    private OwnerRepo ownerRepo;

    @InjectMocks
    OwnerService service;


    @Test
    @DisplayName("Test Should Pass When Repository Method Save Is Called 1 Time")
    void shouldAddOwner() {
        Owner owner = new Owner(1, "Rokas",null);
        when(ownerRepo.existsById(1)).thenReturn(false);
        service.addOwner(owner);

        verify(ownerRepo, times(1)).save(any(Owner.class));
    }

    @Test
    @DisplayName("Test Should Pass When Owner Names Are Different")
    void shouldUpdateOwner() {
        Owner owner = new Owner(1, "Rokas", null);
        Owner updatedOwner = new Owner(1, "Spokas", null);
        when(ownerRepo.save(owner)).thenReturn(updatedOwner);

        assertNotEquals(owner.getName(),service.updateOwner(owner).getName());
    }

    @Test
    @DisplayName("Test Should Pass When Repository Method Delete Is Called 1 Time")
    void shouldDeleteOwner() {
        when(ownerRepo.existsById(1)).thenReturn(true);
        when(ownerRepo.getOne(1)).thenReturn(new Owner()).thenReturn(null);
        service.deleteOwner(1);

        verify(ownerRepo, times(1)).delete(any(Owner.class));
    }

    @Test
    @DisplayName("Test Should Pass When All The Given Owners Are Retrieved")
    void shouldGetAllTheOwners() {
        List<Owner> expectedList = Arrays.asList(
                new Owner(1, "Rokas", null),
                new Owner(2, "Rytis", null)
        );

        when(ownerRepo.findAll()).thenReturn(expectedList);
        List<Owner> actualList = service.getOwners();

        assertEquals(2,actualList.size());
        assertEquals(expectedList,actualList);
        verify(ownerRepo, times(1)).findAll();
    }

    @Test
    @DisplayName("Test Should Pass When Retrieved Owner By Id Is The Same As Expected")
    void shouldFindOwnerById(){
        Owner expectedOwner = new Owner(1, "Rokas", null);
        when(ownerRepo.findById(1)).thenReturn(Optional.of(expectedOwner));

        Owner actualOwner = service.getOwnerById(1);
        assertEquals(actualOwner,expectedOwner);
        assertEquals(actualOwner.getId(),expectedOwner.getId());
        verify(ownerRepo,times(1)).findById(1);
    }
}