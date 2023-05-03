package com.stepaniuik.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "military_unit")
@Table
@Data
@NoArgsConstructor
public class MilitaryUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String militaryUnitNumber;
    private String unitName;
    private String battalionNumber;
    private String company;
    private String fullNameOfCommander;
    private String currentLocation;
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private MilitaryFormation formation;
}
