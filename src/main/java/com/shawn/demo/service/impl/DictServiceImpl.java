package com.shawn.demo.service.impl;

import com.shawn.demo.commons.Page;
import com.shawn.demo.dao.IDictRepository;
import com.shawn.demo.model.Dict;
import com.shawn.demo.service.IDictService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/23.
 */
@Service
public class DictServiceImpl implements IDictService {
    @Autowired
    IDictRepository dao;

    @Override
    public Page<Dict> findDicts(Map<String, Object> params) {
        Long pageIndex = MapUtils.getLong(params, "pageIndex");
        Integer pageSize = MapUtils.getInteger(params, "pageSize");
        Page<Dict> page = new Page<>(pageIndex, pageSize);

        List<Dict> rows = dao.findDicts(params);
        Long count = dao.countDicts(params);

        page.setRows(rows);
        page.setTotal(count);
        return page;
    }
}
