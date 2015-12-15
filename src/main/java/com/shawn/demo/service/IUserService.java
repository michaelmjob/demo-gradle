package com.shawn.demo.service;

import java.util.List;

/**
 * Created by Shawn on 2015/12/15.
 */
public interface IUserService {
    List<String> findRoles(String username);
}
