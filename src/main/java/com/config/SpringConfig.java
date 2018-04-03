package com.config;

import com.user.dao.UserDao;
import com.user.dao.UserDaoImpl;
import com.user.service.TestBean;
import com.user.service.UserService;
import com.user.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public TestBean getTest(){
        return new TestBean("Barev");
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/user_m");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public UserDao geUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService geUserService(){
        return new UserServiceImpl();
    }
}
