package com.shawn.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Shawn on 2015/12/4.
 */
@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.shawn.demo.controller")
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

}
