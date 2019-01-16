package vwmarketbackend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"vwmarketbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/itvdn?useSSL=false";
    private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    private final static String DATABASE_USERNAME = "root";
    private final static String DATABASE_PASSWORD = "root";

    @Bean("dataSource")
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        //Providing db connection information
        basicDataSource.setDriverClassName(DATABASE_DRIVER);
        basicDataSource.setUrl(DATABASE_URL);
        basicDataSource.setUsername(DATABASE_USERNAME);
        basicDataSource.setPassword(DATABASE_PASSWORD);

        return basicDataSource;
    }

    @Bean("sessionFactory")
    public SessionFactory sessionFactory(DataSource dataSource){
        LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        localSessionFactoryBuilder.addProperties(getHibernateProperties());
        localSessionFactoryBuilder.scanPackages("vwmarketbackend.dto");
        return localSessionFactoryBuilder.buildSessionFactory();
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
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        return properties;
    }
}
