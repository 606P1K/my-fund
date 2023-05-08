package com.stepaniuik.service;

import com.stepaniuik.models.MilitaryUnit;
import com.stepaniuik.repo.MilitaryUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilitaryUnitService implements ServiceInterface<MilitaryUnit>{
    @Autowired
    MilitaryUnitRepository unitRepository;
    @Override
    public void save(MilitaryUnit militaryUnit) {
        unitRepository.save(militaryUnit);
    }

    @Override
    public void update(MilitaryUnit militaryUnit) {
        MilitaryUnit newRequest = unitRepository.findById(militaryUnit.getId()).orElseThrow();
        newRequest.setFormation(militaryUnit.getFormation());
        newRequest.setMilitaryUnitNumber(militaryUnit.getMilitaryUnitNumber());
        newRequest.setCompany(militaryUnit.getCompany());
        newRequest.setUnitName(militaryUnit.getUnitName());
        newRequest.setBattalionNumber(militaryUnit.getBattalionNumber());
        newRequest.setCurrentLocation(militaryUnit.getCurrentLocation());
        newRequest.setFullNameOfCommander(militaryUnit.getFullNameOfCommander());

        unitRepository.save(newRequest);
    }

    @Override
    public void delete(MilitaryUnit militaryUnit) {
        unitRepository.delete(militaryUnit);
    }

    @Override
    public Iterable<MilitaryUnit> getAll() {
        return unitRepository.findAll();
    }
}
