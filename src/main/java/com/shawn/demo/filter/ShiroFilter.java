package com.shawn.demo.filter;

import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by Shawn on 2015/12/16.
 */
//@WebFilter(
//    urlPatterns = "/*",
//    filterName = "shiroFilter",
//    description = "Apache Shiro Filter",
//    asyncSupported = true,
//    initParams = {
//        @WebInitParam(name = "targetFilterLifecycle", value = "true")
//    }
//)
public class ShiroFilter extends DelegatingFilterProxy {
    public ShiroFilter() {
        System.out.println("Web Filter Shiro");
    }
}
