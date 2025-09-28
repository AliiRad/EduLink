package com.EduLink.EduLink.model.service;

import com.EduLink.EduLink.model.entity.Person;
import com.EduLink.EduLink.model.repositroy.PersonRepository;
import com.EduLink.EduLink.model.service.impl.ServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class PersonService implements ServiceImpl<Person,Long> {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    @Transactional
    public Person insert(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    @Transactional
    public Person update(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    @Transactional
    public Person delete(Person person) {
        personRepository.delete(person);
        return person;
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).isPresent() ? personRepository.findById(id).get() : null;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findAll(String condition) {
        return null;
    }

    @Override
    public List<Person> findAll(String condition, String order) {
        return null;
    }
}
