package com.zerutis.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Property")
@Table(name="property")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Property
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Integer id;

    @Column(name = "property_type")
    private String propertyType;
    @Column(name  = "tax_rate", precision = 10, scale = 5)
    private BigDecimal taxRate;

    @JsonManagedReference(value = "property")
    @OneToMany(mappedBy="property", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Building> buildings = new ArrayList<>();
}
