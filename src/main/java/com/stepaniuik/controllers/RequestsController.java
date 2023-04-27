package com.stepaniuik.controllers;

import com.stepaniuik.models.MilitaryRequest;
import com.stepaniuik.repo.MilitaryRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RequestsController {
    @Autowired
    private MilitaryRequestRepository repository;

    @GetMapping("/toVolunteer")
    public String volunteerRequest(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 5;
        Page<MilitaryRequest> militaryRequests = repository.findAll(PageRequest.of(page, pageSize));

        model.addAttribute("militaryRequests", militaryRequests.getContent());
        model.addAttribute("totalPages", militaryRequests.getTotalPages());
        model.addAttribute("currentPage", page);

        return "volunteer";
    }

    @GetMapping ("/request")
    public String militaryRequest(Model model) {
        return "military-request";
    }
    @PostMapping (value = "/request", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String militaryRequestPost(@ModelAttribute MilitaryRequest request, @RequestParam MultipartFile fileS,
                                      Model model) throws IOException {

        request.saveFile(fileS);
        repository.save(request);

        return "redirect:/";
    }
}
