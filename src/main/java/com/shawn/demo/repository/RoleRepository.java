package com.shawn.demo.repository;

import com.shawn.demo.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shawn on 2015/12/29.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
