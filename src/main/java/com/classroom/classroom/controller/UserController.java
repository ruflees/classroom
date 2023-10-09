package com.classroom.classroom.controller;

import com.classroom.classroom.dto.UserDTO;
import com.classroom.classroom.dto.UserMinDTO;
import com.classroom.classroom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserMinDTO> findAll(){
        return userService.findAll();
    }

}
