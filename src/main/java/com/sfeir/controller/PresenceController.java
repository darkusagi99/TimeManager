package com.sfeir.controller;

import com.sfeir.model.Presence;
import com.sfeir.service.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PresenceController {

    @Autowired
    PresenceService presenceService;

    /** Mapping page liste des presences */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/presence/list", method = RequestMethod.GET)
    public List<Presence> listPresence() {
        return presenceService.listPresence();
    }



    /** Mapping page création des presences */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/presence/create", method = RequestMethod.POST)
    public Presence createPresence(@Valid Presence presence, BindingResult bindingResult) {

        Presence presenceExists = presenceService.findByPeopleIdAndDate(presence.getPersonId(), presence.getPresenceDay());
        if (presenceExists == null) {
            return presenceService.createPresence(presence);

        }
        return null;

    }



    /** Mapping page mise à jour des presences */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/presence/update", method = RequestMethod.POST)
    public Presence updatePresence(@Valid Presence presence, BindingResult bindingResult) {

        Presence presenceExists = presenceService.findByPeopleIdAndDate(presence.getPersonId(), presence.getPresenceDay());
        if (presenceExists != null) {
            return presenceService.updatePresence(presence);

        }
        return null;
    }

}
