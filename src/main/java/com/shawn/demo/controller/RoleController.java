package com.shawn.demo.controller;

import com.shawn.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2015/12/4.
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    IRoleService service;

    @RequestMapping(path = "/list.do", method = RequestMethod.POST)
    public Map<String,Object> getRoleList(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, Object> params) {
        return service.findRoles(params);
    }
}
