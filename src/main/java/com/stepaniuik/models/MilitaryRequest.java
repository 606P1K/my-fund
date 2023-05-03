package com.stepaniuik.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Entity(name = "military_request")
@Table
@Data
@NoArgsConstructor
public class MilitaryRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String whatRequired;
    private String pathToFile;
    @ManyToOne
    @JoinColumn(name = "military_unit_id")
    private MilitaryUnit militaryUnit;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private ContactPerson person;

    public MilitaryRequest(String email, String whatRequired,
                           MilitaryUnit militaryUnit, ContactPerson person) {
        this.email = email;
        this.whatRequired = whatRequired;
        this.militaryUnit = militaryUnit;
        this.person = person;
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
