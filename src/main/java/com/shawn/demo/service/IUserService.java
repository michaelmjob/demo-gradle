package com.shawn.demo.service;

import com.shawn.demo.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/15.
 */
public interface IUserService {
    User addUser(String username, String password);

    User findUserByName(String username);

    List<String> findRoles(String username);
}
