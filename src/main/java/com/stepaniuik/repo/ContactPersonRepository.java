package com.stepaniuik.repo;

import com.stepaniuik.models.ContactPerson;
import org.springframework.data.repository.CrudRepository;

public interface ContactPersonRepository extends CrudRepository<ContactPerson,Long> {
}
