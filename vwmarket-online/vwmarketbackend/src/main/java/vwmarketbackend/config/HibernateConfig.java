package vwmarketbackend.config;


import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"vwmarketbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

    private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
    private final static String DATABASE_DRIVER = "org.h2.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
    private final static String DATABASE_USERNAME = "sa";
    private final static String DATABASE_PASSWORD = "";

    @Bean("dataSource")
    public DataSource dataSource(){
        System.out.println("!!!! in getDataSource");
        DriverManagerDataSource basicDataSource = new DriverManagerDataSource();

        //Providing db connection information
        basicDataSource.setDriverClassName(DATABASE_DRIVER);
        basicDataSource.setUrl(DATABASE_URL);
        basicDataSource.setUsername(DATABASE_USERNAME);
        basicDataSource.setPassword(DATABASE_PASSWORD);

        return basicDataSource;
    }

    @Bean("sessionFactory")
    public SessionFactory sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBuilder = new LocalSessionFactoryBean();

        localSessionFactoryBuilder.setDataSource(dataSource);
        localSessionFactoryBuilder.setHibernateProperties(getHibernateProperties());
        localSessionFactoryBuilder.setPackagesToScan("vwmarketbackend.dto");

        try {
            localSessionFactoryBuilder.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SessionFactory sessionFactory = localSessionFactoryBuilder.getObject();
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
        return hibernateTransactionManager;
    }

    public Properties getHibernateProperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", DATABASE_DIALECT);
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");

        return properties;
    }
}
