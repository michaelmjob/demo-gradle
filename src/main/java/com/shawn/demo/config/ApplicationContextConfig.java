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
@Import(SpringDataConfig.class)
public class ApplicationContextConfig {

}
