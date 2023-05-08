package com.stepaniuik.service;

import com.stepaniuik.models.MilitaryRequest;
import com.stepaniuik.repo.MilitaryRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MilitaryRequestService implements ServiceInterface<MilitaryRequest>{
    @Autowired
    private MilitaryRequestRepository requestRepository;

    @Override
    public void save(MilitaryRequest militaryRequest) {
        requestRepository.save(militaryRequest);
    }

    @Override
    public void update(MilitaryRequest militaryRequest) {
        MilitaryRequest newRequest = requestRepository.findById(militaryRequest.getId()).orElseThrow();
        newRequest.setMilitaryUnit(militaryRequest.getMilitaryUnit());
        newRequest.setPerson(militaryRequest.getPerson());
        newRequest.setEmail(militaryRequest.getEmail());
        newRequest.setWhatRequired(militaryRequest.getWhatRequired());
        newRequest.setPathToFile(militaryRequest.getPathToFile());

        requestRepository.save(newRequest);
    }

    @Override
    public void delete(MilitaryRequest militaryRequest) {
        requestRepository.delete(militaryRequest);
    }

    @Override
    public Iterable<MilitaryRequest> getAll() {
        return requestRepository.findAll();
    }

    public Page<MilitaryRequest> getAllInPage(PageRequest request){
        return requestRepository.findAll(request);
    }
}
