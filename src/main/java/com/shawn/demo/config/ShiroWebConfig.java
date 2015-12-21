package com.shawn.demo.config;

import com.shawn.demo.filter.ForceLogoutFilter;
import com.shawn.demo.filter.SysUserFilter;
import com.shawn.demo.realm.UserRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.*;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

/**
 * Created by Shawn on 2015/12/14.
 */
@Configuration
public class ShiroWebConfig {

    /*@Bean
    缓存管理器
    public CacheManager cacheManager() {
        SpringCacheManagerWrapper springCacheManagerWrapper = new SpringCacheManagerWrapper
    }*/

    /**
     * 凭证匹配器
     */
    @Bean
    public CredentialsMatcher credentialsMatcher() {
        System.out.println("******** credentialsMatcher()");
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }


    /**
     * Realm实现
     */
    @Bean
    public Realm userRealm() {
        System.out.println("******** userRealm()");
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher());
        userRealm.setCachingEnabled(false);
        return userRealm;
    }

    /**
     * 会话ID生成器
     */
    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        System.out.println("******** sessionIdGenerator()");
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * 会话Cookie模板
     */
    @Bean
    public Cookie sessionIdCookie() {
        System.out.println("******** sessionIdCookie()");
        SimpleCookie sessionIdCookie = new SimpleCookie("sid");
        sessionIdCookie.setName("sid");
        sessionIdCookie.setHttpOnly(true);
        sessionIdCookie.setMaxAge(-1);
        return sessionIdCookie;
    }

    @Bean
    public Cookie rememberMeCookie() {
        System.out.println("******** rememberMeCookie()");
        SimpleCookie rememberMeCookie = new SimpleCookie("rememberMe");
        rememberMeCookie.setHttpOnly(true);
        rememberMeCookie.setMaxAge(30);
        return rememberMeCookie;
    }

    /**
     * rememberMe管理器
     */
    public RememberMeManager rememberMeManager() {
        System.out.println("******** rememberMeManager()");
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(rememberMeCookie());
        return rememberMeManager;
    }

    /**
     * 会话DAO
     */
    @Bean
    public SessionDAO sessionDAO() {
        System.out.println("******** sessionDAO()");
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        sessionDAO.setSessionIdGenerator(sessionIdGenerator());
        return sessionDAO;
    }

    /**
     * 会话验证调度器
     */
    @Bean
    public SessionValidationScheduler sessionValidationScheduler() {
        System.out.println("******** sessionValidationScheduler()");
        QuartzSessionValidationScheduler sessionValidationScheduler = new QuartzSessionValidationScheduler();
        sessionValidationScheduler.setSessionValidationInterval(1800);
        sessionValidationScheduler.setSessionManager(sessionManager());
        return sessionValidationScheduler;
    }

    /**
     * 会话管理器
     */
    @Bean
    public DefaultSessionManager sessionManager() {
        System.out.println("******** sessionManager()");
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1800);
        sessionManager.setDeleteInvalidSessions(true);
//        sessionManager.setSessionValidationSchedulerEnabled(true);
//        sessionManager.setSessionValidationScheduler(sessionValidationScheduler());
        sessionManager.setSessionDAO(sessionDAO());
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(sessionIdCookie());
        return sessionManager;
    }

    /**
     * 安全管理器
     */
    @Bean
    public SecurityManager securityManager() {
        System.out.println("******** securityManager()");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        securityManager.setSessionManager(sessionManager());
//        securityManager.setCacheManager();
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     * 相当于调用SecurityUtils.setSecurityManager(securityManager)
     */


    /**
     * 基于Form表单的身份验证过滤器
     */
    @Bean
    public Filter formAuthenticationFilter() {
        System.out.println("******** formAuthenticationFilter()");
        FormAuthenticationFilter formauthenticationFilter = new FormAuthenticationFilter();
        formauthenticationFilter.setUsernameParam("username");
        formauthenticationFilter.setPasswordParam("password");
        formauthenticationFilter.setRememberMeParam("rememberMe");
        formauthenticationFilter.setLoginUrl("/login.jsp");
        formauthenticationFilter.setSuccessUrl("/main.jsp");
        formauthenticationFilter.setFailureKeyAttribute("shiroLoginFailure");
        return formauthenticationFilter;
    }

    @Bean
    public Filter susUserFilter() {
        System.out.println("******** susUserFilter()");
        return new SysUserFilter();
    }

    @Bean
    public Filter forceLogoutFilter() {
        System.out.println("******** forceLogoutFilter()");
        return new ForceLogoutFilter();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter() {
        System.out.println("******** shiroFilter()");
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setLoginUrl("/login.jsp");

        Map<String, Filter> filters = new HashMap<>();
        filters.put("authc", formAuthenticationFilter());
        filters.put("sysUser", susUserFilter());
        filters.put("forceLogout", forceLogoutFilter());
        shiroFilter.setFilters(filters);

        Map<String, String> definitions = new HashMap<>();
        definitions.put("/index.jsp", "anon");
        definitions.put("/login", "authc");
        definitions.put("/logout", "logout");
        definitions.put("/authenticated", "authc");
        definitions.put("/**", "user,sysUser,forceLogout");
        shiroFilter.setFilterChainDefinitionMap(definitions);

        return shiroFilter;
    }

    @Bean
    public LifecycleBeanPostProcessor shiroLifecycle() {
        System.out.println("******** shiroLifecycle()");
        LifecycleBeanPostProcessor shiroLifecycle = new LifecycleBeanPostProcessor();
        return shiroLifecycle;
    }

    /*



    @Bean
    public ValidatingSessionManager validatingSessionManager() {
        return new AbstractValidatingSessionManager() {
            @Override
            protected Session retrieveSession(SessionKey key) throws UnknownSessionException {
                return null;
            }

            @Override
            protected Session doCreateSession(SessionContext initData) throws AuthorizationException {
                return null;
            }

            @Override
            protected Collection<Session> getActiveSessions() {
                return null;
            }
        };
    }



    @Bean
    public SessionManager sessionManager() {
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setGlobalSessionTimeout(1800);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionValidationScheduler(sessionValidationScheduler());
        sessionManager.setSessionDAO(sessionDAO());
        return sessionManager;
    }

    *//*<!-- Realm实现 -->
    <bean id="userRealm" class="com.github.zhangkaitao.shiro.chapter12.realm.UserRealm">
    <property name="userService" ref="userService"/>
    <property name="credentialsMatcher" ref="credentialsMatcher"/>
    <property name="cachingEnabled" value="true"/>
    <property name="authenticationCachingEnabled" value="true"/>
    <property name="authenticationCacheName" value="authenticationCache"/>
    <property name="authorizationCachingEnabled" value="true"/>
    <property name="authorizationCacheName" value="authorizationCache"/>
    </bean>
            -->*//*


    @Bean
    public SecurityManager securityManager() {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        List<Realm> realms = new ArrayList<>();
        realms.add(new UserRealm());
        securityManager.setRealms(realms);
        return securityManager;
    }

    @Bean
    public Filter formAuthenticationFilter() {
        FormAuthenticationFilter formauthenticationFilter = new FormAuthenticationFilter();
        formauthenticationFilter.setUsernameParam("username");
        formauthenticationFilter.setPasswordParam("password");
        formauthenticationFilter.setRememberMeParam("rememberMe");
        formauthenticationFilter.setLoginUrl("/login");
        return formauthenticationFilter;
    }

    */
}
