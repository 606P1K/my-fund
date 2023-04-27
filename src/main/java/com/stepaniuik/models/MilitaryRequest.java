package com.stepaniuik.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Entity(name = "military_request")
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
    private String whatRequired;
    private String currentLocation;
    private String fullNameOfContactPerson;
    private String phoneOfContactPerson;
    private String pathToFile;
    public MilitaryRequest(String email, String fromWho,
                           String militaryUnitNumber, String unitName,
                           String battalionNumber, String company,
                           String fullNameOfCommander, String whatRequired,
                           String currentLocation, String fullNameOfContactPerson,
                           String phoneOfContactPerson) {
        this.email = email;
        this.fromWho = fromWho;
        this.militaryUnitNumber = militaryUnitNumber;
        this.unitName = unitName;
        this.battalionNumber = battalionNumber;
        this.company = company;
        this.fullNameOfCommander = fullNameOfCommander;
        this.whatRequired = whatRequired;
        this.currentLocation = currentLocation;
        this.fullNameOfContactPerson = fullNameOfContactPerson;
        this.phoneOfContactPerson = phoneOfContactPerson;
    }

    public void saveFile(MultipartFile file) throws IOException {
        pathToFile = "Файл відсутній";

        if(!file.isEmpty()) {
            pathToFile = "D:/Унік/Web/CourseWork/src/main/resources/files/" + file.getOriginalFilename();
            File newFile = new File(pathToFile);
            file.transferTo(newFile);
        }
    }
}
