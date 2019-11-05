package com.sfeir.controller;

import com.sfeir.model.People;
import com.sfeir.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    /** Mapping page liste des personnes */
    @RequestMapping(value = "/people/list", method = RequestMethod.GET)
    public ModelAndView listPeople() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }



    /** Mapping page création des personnes */
    @RequestMapping(value = "/people/create", method = RequestMethod.POST)
    public ModelAndView createPeople(@Valid People people, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        People peopleExists = peopleService.findByFullname(people.getFullname());
        if (peopleExists != null) {
            bindingResult
                    .rejectValue("fullname", "error.people",
                            "There is already a person registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            peopleService.createPeople(people);
            modelAndView.addObject("successMessage", "Person has been registered successfully");
            modelAndView.addObject("people", new People());
            modelAndView.setViewName("login");

        }
        return modelAndView;

    }



    /** Mapping page mise à jour des personnes */
    @RequestMapping(value = "/people/update", method = RequestMethod.POST)
    public ModelAndView updatePeople(@Valid People people, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        People peopleExists = peopleService.findByFullname(people.getFullname());
        if (peopleExists == null) {
            bindingResult
                    .rejectValue("fullname", "error.people",
                            "There no person registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            peopleService.updatePeople(people);
            modelAndView.addObject("successMessage", "Person has been updated successfully");
            modelAndView.addObject("people", new People());
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }

}
