package com.shawn.demo.dao.impl;

import com.shawn.demo.dao.IDictDao;
import com.shawn.demo.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/23.
 */
@Repository
public class DictDaoImpl implements IDictDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Dict> findAll() {
        return null;
    }

    //    @Override
    public List<Dict> findDicts(Map<String, Object> params) {
        String sql = "select id,code,text,type,scope,available,description from sys_dict";
        return jdbcTemplate.queryForList(sql, Dict.class);
    }

//    @Override
    public Long countDicts(Map<String, Object> params) {
        String sql = "select count(id) from sys_dict";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}
