package com.stepaniuik.controllers;

import com.stepaniuik.models.ContactPerson;
import com.stepaniuik.models.MilitaryFormation;
import com.stepaniuik.models.MilitaryRequest;
import com.stepaniuik.models.MilitaryUnit;
import com.stepaniuik.repo.ContactPersonRepository;
import com.stepaniuik.repo.MilitaryFormationRepository;
import com.stepaniuik.repo.MilitaryRequestRepository;
import com.stepaniuik.repo.MilitaryUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RequestController {
    @Autowired
    private MilitaryRequestRepository requestRepository;
    @Autowired
    private MilitaryFormationRepository formationRepository;
    @Autowired
    private MilitaryUnitRepository unitRepository;
    @Autowired
    private ContactPersonRepository personRepository;

    @PostMapping (value = "/request",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String militaryRequestPost(@ModelAttribute MilitaryRequest request,
                                      @RequestParam("fromWho") String militaryFormationName,
                                      @ModelAttribute ContactPerson person,
                                      @ModelAttribute MilitaryUnit unit,
                                      @RequestParam MultipartFile fileS) throws IOException {
        MilitaryFormation formation = formationRepository
                .findMilitaryFormationByMilitaryFormationName(militaryFormationName);
        unit.setFormation(formation);
        unitRepository
                .save(unit);

        personRepository
                .save(person);

        request.setMilitaryUnit(unit);
        request.setPerson(person);
        request.saveFile(fileS);

        requestRepository
                .save(request);

        return "redirect:/";
    }
}
