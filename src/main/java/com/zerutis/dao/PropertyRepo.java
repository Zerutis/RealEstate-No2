package com.zerutis.dao;

import com.zerutis.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo  extends JpaRepository<Property,Integer> {

}