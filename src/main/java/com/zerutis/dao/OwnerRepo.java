package com.zerutis.dao;

import com.zerutis.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer>
{
    @Query(value = "select p.tax_rate from Building b, Property p"
            + " where b.property_id = p.property_id"
            + " and b.owner_id = :id", nativeQuery = true)
    List<BigDecimal> findTaxRateById(@Param("id") int id);

    @Query(value = "select b.value from Building b"
            + " where b.owner_id = :id", nativeQuery = true)
    List<BigDecimal> findValueById(@Param("id") int id);
}
