package com.shawn.demo.dao.impl;

import com.shawn.demo.dao.IUserDao;
import com.shawn.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Shawn on 2015/12/16.
 */
@Repository
public class UserDaoImpl implements IUserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User addUser(User user) {
        String sql = "insert into sys_user(username, password) values(?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
//                ps.setLong(count++, user.getOrganizationId());
                ps.setString(count++, user.getUsername());
                ps.setString(count++, user.getPassword());
//                ps.setString(count++, user.getSalt());
//                List roleIds = user.getRoleIds();
//                Long[] array = (Long[]) roleIds.toArray(new Long[roleIds.size()]);
//                ps.setArray(count++, connection.createArrayOf("BIGINT", array));
//                ps.setBoolean(count++, user.getLocked());
                return ps;
            }
        }, keyHolder);

        user.setId(keyHolder.getKey().longValue());
        return user;
    }

    @Override
    public User findUserByName(String username) {
        String sql = "select * from sys_user where username = ? ";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(), username);
        if (userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }
}
