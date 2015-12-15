package com.shawn.demo.service.impl;

import com.shawn.demo.dao.IRoleDao;
import com.shawn.demo.model.Role;
import com.shawn.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/10.
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao dao;

    @Override
    public Role findRoleById(Long id) {
        return dao.findRoleById(id);
    }

    @Override
    public List<Map<String, Object>> findRoles(Map<String, Object> params) {
//        System.out.println("role list is null");
        return null;
    }
}
