package com.shawn.demo.dao;

import com.shawn.demo.model.User;

/**
 * Created by Shawn on 2015/12/16.
 */
public interface IUserDao {
    User addUser(User user);

    User findUserByName(String username);
}
