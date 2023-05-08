package com.stepaniuik.service;

import com.stepaniuik.models.MilitaryFormation;
import com.stepaniuik.repo.MilitaryFormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilitaryFormationService implements ServiceInterface<MilitaryFormation>{
    @Autowired
    private MilitaryFormationRepository formationRepository;

    @Override
    public void save(MilitaryFormation formation) {
        formationRepository.save(formation);
    }

    @Override
    public void update(MilitaryFormation formation) {
        return;
    }

    @Override
    public void delete(MilitaryFormation formation) {
        return;
    }

    @Override
    public Iterable<MilitaryFormation> getAll() {
        return formationRepository.findAll();
    }

    public MilitaryFormation findMilitaryFormationByMilitaryFormationName(String militaryFormationName){
        return formationRepository.
                findMilitaryFormationByMilitaryFormationName(militaryFormationName);
    }
}
