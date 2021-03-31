package com.zerutis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name="Building")
@Table(name="building")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Building
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="owner_id")
    @JsonBackReference(value = "owner")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name="property_id")
    @JsonBackReference(value = "property")
    private Property property;

    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private int number;
    @Column(name = "size")
    private double size;
    @Column(name = "value", precision = 10, scale = 5)
    private BigDecimal value;
}