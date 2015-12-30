package com.shawn.demo.service.impl;

import com.shawn.demo.dao.IRoleDao;
import com.shawn.demo.model.Role;
import com.shawn.demo.repository.RoleRepository;
import com.shawn.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/10.
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao dao;

    @Autowired
    RoleRepository repository;

    @Override
    public Role findRoleById(Long id) {
        return dao.findRoleById(id);
    }

    @Override
    public Map<String, Object> findRoles(Map<String, Object> params) {
        Map<String,Object> result = new HashMap<>();

        result.put("success", true);
        result.put("rows", repository.findAll());
        return result;
    }
}
