package com.shawn.demo.service.impl;

import com.shawn.demo.dao.IUserDao;
import com.shawn.demo.model.User;
import com.shawn.demo.repository.UserRepository;
import com.shawn.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shawn on 2015/12/15.
 */
@Service
public class UserServiceImpl implements IUserService {
//    @Autowired
//    IUserDao dao;

    @Autowired UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User addUser(String username, String password) {
        User user = new User(username, password);
//        return dao.addUser(user);
        return null;
    }

    @Override
    public User findUserByName(String username) {
//        return dao.findUserByName(username);
        return null;
    }

    @Override
    public List<String> findRoles(String username) {
        return null;
    }
}
