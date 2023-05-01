package com.stepaniuik.controllers;

import com.stepaniuik.models.MilitaryRequest;
import com.stepaniuik.repo.MilitaryRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/request")
public class RequestController {
    @Autowired
    private MilitaryRequestRepository repository;

    @GetMapping
    public String militaryRequest() {
        return "military-request";
    }
    @PostMapping (consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String militaryRequestPost(@ModelAttribute MilitaryRequest request,
                                      @RequestParam MultipartFile fileS) throws IOException {

        request.saveFile(fileS);
        repository.save(request);

        return "redirect:/";
    }
}
