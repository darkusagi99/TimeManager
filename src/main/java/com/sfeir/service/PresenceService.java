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

    public void createPresence(Presence newPresence) {
        presenceRepository.save(newPresence);
    }

    public void updatePresence(Presence newPresence) {
        // Rechercher la personne existante
        Optional<Presence> presenceToUpdate = presenceRepository.findById(newPresence.getId());

        // Copie des champs
        // TODO

        // Mise à jour des données
        presenceRepository.save(presenceToUpdate.get());
    }

    public List<Presence> findByPeopleId(String personId) {
        return presenceRepository.findByPersonId(personId);
    }



    public Presence findByPeopleIdAndDate(String personId, Date presenceDay) {
        return presenceRepository.findByPersonIdAndPresenceDay(personId, presenceDay);
    }

}
