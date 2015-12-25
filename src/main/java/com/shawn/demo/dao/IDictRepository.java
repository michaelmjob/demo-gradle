package com.shawn.demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/23.
 */
public interface IDictRepository<Dict, ID extends Serializable> extends PagingAndSortingRepository<Dict, ID> {

    List<Dict> findAll();

    List<Dict> findDicts(Map<String, Object> params);

    Long countDicts(Map<String, Object> params);
}
