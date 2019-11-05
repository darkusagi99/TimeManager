package com.sfeir.controller;

import com.sfeir.model.Presence;
import com.sfeir.service.PresenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PresenceController {

    @Autowired
    PresenceService presenceService;

    /** Mapping page liste des presences */
    @RequestMapping(value = "/presence/list", method = RequestMethod.GET)
    public ModelAndView listPresence() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("presence");
        return modelAndView;
    }



    /** Mapping page création des presences */
    @RequestMapping(value = "/presence/create", method = RequestMethod.POST)
    public ModelAndView createPresence(@Valid Presence presence, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        Presence presenceExists = presenceService.findByPeopleIdAndDate(presence.getPersonId(), presence.getPresenceDay());
        if (presenceExists != null) {
            bindingResult
                    .rejectValue("fullname", "error.presence",
                            "There is already a person registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            presenceService.createPresence(presence);
            modelAndView.addObject("successMessage", "Person has been registered successfully");
            modelAndView.addObject("presence", new Presence());
            modelAndView.setViewName("presence");

        }
        return modelAndView;

    }



    /** Mapping page mise à jour des presences */
    @RequestMapping(value = "/presence/update", method = RequestMethod.POST)
    public ModelAndView updatePresence(@Valid Presence presence, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        Presence presenceExists = presenceService.findByPeopleIdAndDate(presence.getPersonId(), presence.getPresenceDay());
        if (presenceExists == null) {
            bindingResult
                    .rejectValue("fullname", "error.presence",
                            "There no person registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("signup");
        } else {
            presenceService.updatePresence(presence);
            modelAndView.addObject("successMessage", "Person has been updated successfully");
            modelAndView.addObject("presence", new Presence());
            modelAndView.setViewName("presence");

        }
        return modelAndView;
    }

}
