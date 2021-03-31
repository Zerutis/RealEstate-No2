package com.zerutis.service;

import com.zerutis.dao.OwnerRepo;
import com.zerutis.exception.ResourceAlreadyExistException;
import com.zerutis.exception.ResourceNotFoundException;
import com.zerutis.model.Owner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerService {
    private final OwnerRepo ownerRepo;

    public Owner addOwner(Owner owner) {
        if(ownerRepo.existsById(owner.getId()))
            throw new ResourceAlreadyExistException("Owner By ID: " + owner.getId() + " Already Exists");
        return ownerRepo.save(owner);
    }

    public Owner updateOwner(Owner owner) {
        return ownerRepo.save(owner);
    }

    public String deleteOwner(int id) {
        if(ownerRepo.existsById(id))
            ownerRepo.delete(ownerRepo.getOne(id));
        else
            throw new ResourceNotFoundException("Owner By ID: " + id + " Not Found");
        return "Owner Deleted Successfully";
    }

    public List<Owner> getOwners(){
        return ownerRepo.findAll();
    }

    public Owner getOwnerById(int id) {
        return ownerRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner By ID: " + id + " Not Found"));
    }
}
