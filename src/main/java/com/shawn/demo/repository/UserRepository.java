package com.shawn.demo.repository;

import com.shawn.demo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Shawn on 2015/12/28.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
