package com.sfeir.service;

import com.sfeir.model.Presence;
import com.sfeir.repository.PresenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import java.util.Calendar;
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

        Calendar cal = Calendar.getInstance();
        cal.setTime(newPresence.getPresenceDay());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        newPresence.setPresenceDay(cal.getTime());

        return presenceRepository.save(newPresence);
    }

    public Presence updatePresence(Presence newPresence) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(newPresence.getPresenceDay());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        newPresence.setPresenceDay(cal.getTime());

        // Mise à jour des données
        return presenceRepository.save(newPresence);
    }

    public List<Presence> findByPeopleId(String personId) {
        return presenceRepository.findByPersonId(personId);
    }



    public Presence findByPeopleIdAndDate(String personId, Date presenceDay) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(presenceDay);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return presenceRepository.findByPersonIdAndPresenceDay(personId, cal.getTime());
    }


    public Presence findById(String id) {
        return presenceRepository.findById(id).orElse(null);
    }

}
