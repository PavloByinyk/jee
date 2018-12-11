package com.youtube.config;

import com.youtube.dao.UserDao;
import com.youtube.dao.UserDaoImpl;
import com.youtube.service.UserService;
import com.youtube.service.UserServiseimpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.youtube.service", "com.youtube.dao"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbctemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/itvdn?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

//    @Bean
//    public UserDao getUserDao(){   TODO: change on @ComponentScan(basePackages = {"com.youtube.service", "com.youtube.dao"})
//        return new UserDaoImpl();
//    }

//    @Bean
//    public UserService getUserService(){
//        return new UserServiseimpl();
//    }

}
