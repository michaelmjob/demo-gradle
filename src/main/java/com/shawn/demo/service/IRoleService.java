package com.shawn.demo.service;

import com.shawn.demo.model.Role;

import java.util.Map;

/**
 * Created by Shawn on 2015/12/10.
 */
public interface IRoleService {

    Role findRoleById(Long id);

    Map<String, Object> findRoles(Map<String, Object> params);


}
