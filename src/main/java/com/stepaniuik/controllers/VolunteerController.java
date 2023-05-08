package com.stepaniuik.controllers;

import com.stepaniuik.models.MilitaryRequest;
import com.stepaniuik.service.MilitaryRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/toVolunteer")
public class VolunteerController {
    @Autowired
    private MilitaryRequestService requestService;
    @GetMapping
    public String volunteerRequest(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 3;
        Page<MilitaryRequest> militaryRequests = requestService.getAllInPage(PageRequest.of(page, pageSize));

        model.addAttribute("militaryRequests", militaryRequests.getContent());
        model.addAttribute("totalPages", militaryRequests.getTotalPages());
        model.addAttribute("currentPage", page);

        return "volunteer";
    }
}
