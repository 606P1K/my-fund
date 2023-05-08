package com.stepaniuik.controllers;

import com.stepaniuik.models.ContactPerson;
import com.stepaniuik.models.MilitaryFormation;
import com.stepaniuik.models.MilitaryRequest;
import com.stepaniuik.models.MilitaryUnit;
import com.stepaniuik.service.ContactPersonService;
import com.stepaniuik.service.MilitaryFormationService;
import com.stepaniuik.service.MilitaryRequestService;
import com.stepaniuik.service.MilitaryUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RequestController {
    @Autowired
    private MilitaryRequestService requestService;
    @Autowired
    private MilitaryFormationService formationService;
    @Autowired
    private MilitaryUnitService unitService;
    @Autowired
    private ContactPersonService personService;

    @PostMapping (value = "/request",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String militaryRequestPost(@ModelAttribute MilitaryRequest request,
                                      @RequestParam("fromWho") String militaryFormationName,
                                      @ModelAttribute ContactPerson person,
                                      @ModelAttribute MilitaryUnit unit,
                                      @RequestParam MultipartFile fileS) throws IOException {
        MilitaryFormation formation = formationService
                .findMilitaryFormationByMilitaryFormationName(militaryFormationName);
        unit.setFormation(formation);
        unitService
                .save(unit);

        personService
                .save(person);

        request.setMilitaryUnit(unit);
        request.setPerson(person);
        request.saveFile(fileS);

        requestService
                .save(request);

        return "redirect:/";
    }
}
