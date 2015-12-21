package com.shawn.demo.config;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Shawn on 2015/12/4.
 */
@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.shawn.demo.controller")
@Import(ShiroWebConfig.class)
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(new ShiroWebConfig().securityManager());
        return authorizationAttributeSourceAdvisor;
    }

}
