package com.sfeir.service;

import com.sfeir.model.People;
import com.sfeir.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;


    public List<People> listPeople() {

        return peopleRepository.findAll();

    }

    public void createPeople(People newPeople) {
        peopleRepository.save(newPeople);
    }

    public void updatePeople(People newPeople) {
        // Rechercher la personne existante
        People peopleToUpdate = peopleRepository.findByFullname(newPeople.getFullname());

        // Copie des champs
        // TODO

        // Mise à jour des données
        peopleRepository.save(peopleToUpdate);
    }

    public People findByFullname(String fullname) {
        return peopleRepository.findByFullname(fullname);
    }

}
