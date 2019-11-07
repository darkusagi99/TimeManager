package com.sfeir.service;

import com.sfeir.model.Presence;
import com.sfeir.repository.PresenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PresenceService {

    @Autowired
    PresenceRepository presenceRepository;


    public List<Presence> listPresence() {

        return presenceRepository.findAll();

    }

    public Presence createPresence(Presence newPresence) {

        return presenceRepository.save(newPresence);
    }

    public Presence updatePresence(Presence newPresence) {
        // Mise à jour des données
        return presenceRepository.save(newPresence);
    }

    public List<Presence> findByPeopleId(String personId) {
        return presenceRepository.findByPersonId(personId);
    }



    public Presence findByPeopleIdAndDate(String personId, Date presenceDay) {
        return presenceRepository.findByPersonIdAndPresenceDay(personId, presenceDay);
    }


    public Presence findById(String id) {
        return presenceRepository.findById(id).orElse(null);
    }

}
