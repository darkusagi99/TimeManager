package com.sfeir.controller;

import com.sfeir.model.User;
import com.sfeir.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    CustomUserDetailsService userService;

    /** Mapping page liste des utilisateurs */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> listPeople() {
        return userService.listUsers();
    }

}
