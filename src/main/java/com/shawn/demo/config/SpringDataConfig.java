package com.shawn.demo.config;

import com.shawn.demo.repository.BaseRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

/**
 * Created by Shawn on 2015/12/24.
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = BaseRepositoryImpl.class)
public class SpringDataConfig {

//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
////        entityManagerFactoryBean.set
//        return entityManagerFactoryBean;
//    }
}
