package com.sample.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.person.model.PersonsEntity;
 
@Repository
public interface PersonsRepository
        extends JpaRepository<PersonsEntity, Long> {
 
}
