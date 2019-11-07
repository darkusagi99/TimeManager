package com.sfeir.controller;

import com.sfeir.model.User;
import com.sfeir.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    CustomUserDetailsService userService;

    /** Mapping page liste des utilisateurs */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public List<User> listPeople() {
        return userService.listUsers();
    }


    /** Mapping page liste des utilisateurs */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User listPeople(@PathVariable String id) {
        return userService.findUserById(id).orElse(null);
    }

}
