package com.shawn.demo.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


/**
 * Created by Shawn on 2015/12/4.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.shawn.demo"})
@PropertySource("classpath:jdbc.properties")
public class ApplicationContextConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Bean
    public DataSource dataSource() {
        PoolConfiguration poolConfiguration = new PoolProperties();
//        poolConfiguration.setDriverClassName(driverClassName);
//        poolConfiguration.setUrl(url);
//        poolConfiguration.setUsername(username);
//        poolConfiguration.setPassword(password);
        poolConfiguration.setDriverClassName("com.mysql.jdbc.Driver");
        poolConfiguration.setUrl("jdbc:mysql://localhost:3306/demo");
        poolConfiguration.setUsername("shawn");
        poolConfiguration.setPassword("shawn");
        DataSource dataSource = new DataSource(poolConfiguration);
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }
}
