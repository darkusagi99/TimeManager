package com.sfeir.controller;

import com.sfeir.model.People;
import com.sfeir.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    /** Mapping page liste des personnes */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/people/", method = RequestMethod.GET)
    public List<People> listPeople() {
        return peopleService.listPeople();
    }

    /** Mapping page liste des personnes */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public People getPeople(@PathVariable String id) {
        return peopleService.findPeopleById(id);
    }



    /** Mapping page création des personnes */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/people/", method = RequestMethod.PUT)
    public People createPeople(@RequestBody People people) {

        People peopleExists = peopleService.findByFullname(people.getFullname());
        if (peopleExists == null) {
            return peopleService.createPeople(people);

        }

        return null;
    }



    /** Mapping page mise à jour des personnes */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/people/", method = RequestMethod.POST)
    public People updatePeople(@RequestBody People people) {

        People peopleExists = peopleService.findPeopleById(people.getId());
        if (peopleExists != null) {
            return peopleService.updatePeople(people);
        }

        return null;
    }

}
