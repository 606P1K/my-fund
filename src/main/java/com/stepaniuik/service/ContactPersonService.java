package com.stepaniuik.service;

import com.stepaniuik.models.ContactPerson;
import com.stepaniuik.repo.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactPersonService implements ServiceInterface<ContactPerson>{
    @Autowired
    private ContactPersonRepository personRepository;
    @Override
    public void save(ContactPerson person) {
       personRepository.save(person);
    }

    @Override
    public void update(ContactPerson person) {
        ContactPerson newPerson = personRepository.findById(person.getId()).orElseThrow();
        newPerson.setPhoneOfContactPerson(person.getPhoneOfContactPerson());
        newPerson.setFullNameOfContactPerson(person.getFullNameOfContactPerson());

        personRepository.save(newPerson);
    }

    @Override
    public void delete(ContactPerson person) {
        personRepository.delete(person);
    }

    @Override
    public Iterable<ContactPerson> getAll() {
        return personRepository.findAll();
    }
}
