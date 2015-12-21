package com.shawn.demo.filter;

import com.shawn.demo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Shawn on 2015/12/16.
 */
public class SysUserFilter extends PathMatchingFilter {
    @Autowired
    private IUserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("user", userService.findUserByName(username));
        return true;
    }
}
