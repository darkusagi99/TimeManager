package com.sfeir.controller;

import com.sfeir.model.Presence;
import com.sfeir.service.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PresenceController {

    @Autowired
    PresenceService presenceService;

    /** Mapping page liste des presences */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/presence/", method = RequestMethod.GET)
    public List<Presence> listPresence() {
        return presenceService.listPresence();
    }

    /** Mapping page liste des presences */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/presence/{id}", method = RequestMethod.GET)
    public Presence getPresence(@PathVariable String id) {
        return presenceService.findById(id);
    }



    /** Mapping page création des presences */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/presence/", method = RequestMethod.PUT)
    public Presence createPresence(@RequestBody Presence presence) {

        Presence presenceExists = presenceService.findByPeopleIdAndDate(presence.getPersonId(), presence.getPresenceDay());
        if (presenceExists == null) {
            return presenceService.createPresence(presence);

        }
        return null;

    }



    /** Mapping page mise à jour des presences */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/presence/", method = RequestMethod.POST)
    public Presence updatePresence(@RequestBody Presence presence) {

        Presence presenceExists = presenceService.findById(presence.getId());
        if (presenceExists != null) {
            return presenceService.updatePresence(presence);

        }
        return null;
    }

}
