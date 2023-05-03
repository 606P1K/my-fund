package com.stepaniuik.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "military_formation")
@Table
@Data
@NoArgsConstructor
public class MilitaryFormation {
    @Id
    private Long id;
    private String militaryFormationName;
}
