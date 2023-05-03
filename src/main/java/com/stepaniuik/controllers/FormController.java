package com.stepaniuik.controllers;

import com.stepaniuik.models.MilitaryFormation;
import com.stepaniuik.repo.MilitaryFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FormController {
    @Autowired
    private MilitaryFormationRepository repository;

    @GetMapping("/request")
    public String volunteerRequest(Model model) {
        Iterable<MilitaryFormation> formationList = repository.findAll();
        model.addAttribute("militaryFormation",formationList);
        return "military-request";
    }
}
