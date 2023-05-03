package com.stepaniuik.repo;

import com.stepaniuik.models.MilitaryFormation;
import org.springframework.data.repository.CrudRepository;

public interface MilitaryFormationRepository extends CrudRepository<MilitaryFormation,Long> {
    MilitaryFormation findMilitaryFormationByMilitaryFormationName(String militaryFormationName);
}
