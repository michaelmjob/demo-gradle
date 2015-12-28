package com.shawn.demo.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by Shawn on 2015/12/25.
 */
@NoRepositoryBean
public interface IBaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
}
