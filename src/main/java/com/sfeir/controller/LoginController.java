package com.sfeir.controller;

import com.sfeir.model.User;
import com.sfeir.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private CustomUserDetailsService userService;

    /** Mapping page de login */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:3000")
    public void createUser(@RequestBody User user) {
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            return;
        } else {
            userService.saveUser(user);

        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public void updateUser(@RequestBody User user) {
        User userExists = userService.findUserById(user.getId()).orElse(null);
        if (userExists != null) {
            userService.saveUser(user);
        }
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Welcome " + user.getFullname());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }


}
