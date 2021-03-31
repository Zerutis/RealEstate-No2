package com.zerutis.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Owner")
@Table(name="owner")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Owner
{
    @Column(name = "owner_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference(value = "owner")
    @OneToMany(mappedBy="owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Building> buildings = new ArrayList<>();


}