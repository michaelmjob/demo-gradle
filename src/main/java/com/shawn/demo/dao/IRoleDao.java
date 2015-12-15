package com.shawn.demo.dao;

import com.shawn.demo.model.Role;

/**
 * Created by Shawn on 2015/12/15.
 */
public interface IRoleDao {
    Role findRoleById(Long id);
}
