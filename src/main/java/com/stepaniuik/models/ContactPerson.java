package com.stepaniuik.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "contact_person")
@Table
@Data
@NoArgsConstructor
public class ContactPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullNameOfContactPerson;
    private String phoneOfContactPerson;
}
