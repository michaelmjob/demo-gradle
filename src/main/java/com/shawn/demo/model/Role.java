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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "available")
    private Boolean available = Boolean.FALSE;
    @Column(name = "description")
    private String description;

    //    private List<Long> resourcesIds;
    @ManyToMany(
            cascade = CascadeType.REFRESH,
            mappedBy = "roles",
            fetch = FetchType.LAZY
    )
    private List<User> users = new ArrayList<>();

    public Role() {

    }

    public Role(String code, String name, String description, Boolean available) {
        this.code = code;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
