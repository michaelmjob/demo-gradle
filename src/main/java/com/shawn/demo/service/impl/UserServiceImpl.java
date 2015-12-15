package com.shawn.demo.service.impl;

import com.shawn.demo.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shawn on 2015/12/15.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public List<String> findRoles(String username) {
        return null;
    }
}
