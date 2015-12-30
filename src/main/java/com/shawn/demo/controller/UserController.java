package com.shawn.demo.controller;

import com.shawn.demo.model.User;
import com.shawn.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/4.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService service;

    @RequestMapping("/register.do")
    public User register(@RequestParam("username") String username, @RequestParam("password") String password) {
        return service.addUser(username, password);
    }

    @RequestMapping("/login.do")
    public User login() {
        return null;
    }

    @RequestMapping("/list.do")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserList() {
        return service.findAll();
    }
}
