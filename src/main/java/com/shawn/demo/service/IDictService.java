package com.shawn.demo.service;

import com.shawn.demo.commons.Page;
import com.shawn.demo.model.Dict;

import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/23.
 */
public interface IDictService {
    Page<Dict> findDicts(Map<String, Object> params);
}
