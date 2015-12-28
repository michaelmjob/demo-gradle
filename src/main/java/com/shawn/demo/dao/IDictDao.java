package com.shawn.demo.dao;

import com.shawn.demo.model.Dict;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/23.
 */
public interface IDictDao {

    List<Dict> findAll();

    List<Dict> findDicts(Map<String, Object> params);

    Long countDicts(Map<String, Object> params);
}
