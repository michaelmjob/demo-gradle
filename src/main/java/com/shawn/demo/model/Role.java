package com.shawn.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shawn on 2015/12/15.
 */
@Entity
@Table(name = "sys_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
    private String description;

    //    private List<Long> resourcesIds;
    @ManyToMany(
            cascade = CascadeType.REFRESH,
            mappedBy = "roles",
            fetch = FetchType.LAZY
    )
    private List<User> users = new ArrayList<>();
    private Boolean available = Boolean.FALSE;

    public Role() {

    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Long> getResourcesIds() {
//        return resourcesIds;
//    }

//    public void setResourcesIds(List<Long> resourcesIds) {
//        this.resourcesIds = resourcesIds;
//    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
