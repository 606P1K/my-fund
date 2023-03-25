package com.stepaniuik.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MilitaryRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String fromWho;
    private String militaryUnitNumber;
    private String unitName;//Brigade number or unit name
    private String battalionNumber;
    private String company;
    private String fullNameOfCommander;
    private String required;
    private String currentLocation;
    private String fullNameOfContactPerson;
    private String phoneOfContactPerson;

    public MilitaryRequest(String email, String fromWho,
                           String militaryUnitNumber, String unitName,
                           String battalionNumber, String company,
                           String fullNameOfCommander, String required,
                           String currentLocation, String fullNameOfContactPerson,
                           String phoneOfContactPerson) {
        this.email = email;
        this.fromWho = fromWho;
        this.militaryUnitNumber = militaryUnitNumber;
        this.unitName = unitName;
        this.battalionNumber = battalionNumber;
        this.company = company;
        this.fullNameOfCommander = fullNameOfCommander;
        this.required = required;
        this.currentLocation = currentLocation;
        this.fullNameOfContactPerson = fullNameOfContactPerson;
        this.phoneOfContactPerson = phoneOfContactPerson;
    }
}
