package com.stepaniuik.controllers;

import com.stepaniuik.models.MilitaryRequest;
import com.stepaniuik.repo.MilitaryRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestsController {
    @Autowired
    private MilitaryRequestRepository repository;
    @GetMapping("/toVolunteer")
    public String volunteerRequest(Model model) {
        Iterable<MilitaryRequest> militaryRequests = repository.findAll();
        model.addAttribute("militaryRequests", militaryRequests);
        return "volunteer";
    }
    @GetMapping ("/request")
    public String militaryRequest(Model model) {
        return "military-request";
    }
    @PostMapping ("/request")
    public String militaryRequestPost(@RequestParam String email, @RequestParam String fromWho,
                                      @RequestParam String militaryUnitNumber,@RequestParam String unitName,
                                      @RequestParam String battalionNumber, @RequestParam String company,
                                      @RequestParam String fullNameOfCommander,@RequestParam String what_required,
                                      @RequestParam String currentLocation,@RequestParam String fullNameOfContactPerson,
                                      @RequestParam String phoneOfContactPerson,
                                      Model model) {
        MilitaryRequest militaryRequest = new MilitaryRequest(email,fromWho,militaryUnitNumber,
                unitName,battalionNumber,company,fullNameOfCommander,what_required,currentLocation,
                fullNameOfContactPerson,phoneOfContactPerson);
        System.out.println(email);
        repository.save(militaryRequest);

        return "redirect:/";
    }
}
