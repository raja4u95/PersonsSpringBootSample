package com.sample.person.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.person.exception.RecordNotFoundException;
import com.sample.person.model.PersonsEntity;
import com.sample.person.repository.PersonsRepository;
 
@Service
public class PersonsService {
     
    @Autowired
    PersonsRepository repository;
     
    public List<PersonsEntity> getAllPersons()
    {
        List<PersonsEntity> PersonsList = repository.findAll();
         
        if(PersonsList.size() > 0) {
            return PersonsList;
        } else {
            return new ArrayList<PersonsEntity>();
        }
    }
     
    public PersonsEntity getPersonsById(Long id) throws RecordNotFoundException
    {
        Optional<PersonsEntity> Persons = repository.findById(id);
         
        if(Persons.isPresent()) {
            return Persons.get();
        } else {
            throw new RecordNotFoundException("No Persons record exist for given id");
        }
    }
     
    public PersonsEntity createOrUpdatePersons(PersonsEntity entity) throws RecordNotFoundException
    {
        Optional<PersonsEntity> Persons = repository.findById(entity.getId());
         
        if(Persons.isPresent())
        {
            PersonsEntity newEntity = Persons.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deletePersonsById(Long id) throws RecordNotFoundException
    {
        Optional<PersonsEntity> Persons = repository.findById(id);
         
        if(Persons.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Persons record exist for given id");
        }
    }
}