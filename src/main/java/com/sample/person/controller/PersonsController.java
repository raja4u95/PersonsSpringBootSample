package com.sample.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.person.exception.RecordNotFoundException;
import com.sample.person.model.PersonsEntity;
import com.sample.person.service.PersonsService;
 
@RestController
@RequestMapping("/app/v1/service/persons")
public class PersonsController
{
    @Autowired
    PersonsService service;
 
    @GetMapping
    public ResponseEntity<List<PersonsEntity>> getAllPersons() {
        List<PersonsEntity> list = service.getAllPersons();
 
        return new ResponseEntity<List<PersonsEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<PersonsEntity> getPersonsById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        PersonsEntity entity = service.getPersonsById(id);
 
        return new ResponseEntity<PersonsEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<PersonsEntity> createOrUpdatePersons(@RequestBody PersonsEntity Persons)
                                                    throws RecordNotFoundException {
        PersonsEntity updated = service.createOrUpdatePersons(Persons);
        return new ResponseEntity<PersonsEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deletePersonsById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deletePersonsById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}