package com.shawn.demo.dao.impl;

import com.shawn.demo.dao.IRoleDao;
import com.shawn.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Shawn on 2015/12/15.
 */
@Repository
public class RoleDaoImpl implements IRoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Role findRoleById(Long id) {
        final String sql = "select id, role, description, resource_ids as resourceIdsStr, available from sys_role where id=?";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Role.class), id);
        if(roleList.size() == 0) {
            return null;
        }
        return roleList.get(0);
    }
}
