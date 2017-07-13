/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Bruno Strano
 */

@EnableTransactionManagement
public class JPAConfiguration {
    

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
       LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
       
       
       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       factoryBean.setJpaVendorAdapter(vendorAdapter);
       // DataSource  - Gerencia as conexões
       DriverManagerDataSource dataSource= new DriverManagerDataSource();
       dataSource.setUsername("root");
       dataSource.setPassword("cogumelo");
       dataSource.setUrl("jdbc:mysql://localhost:3306/moneyspring");
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       factoryBean.setDataSource(dataSource);
       
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        factoryBean.setJpaProperties(props);
       
       
      
       factoryBean.setPackagesToScan("br.stralom.moneyspring.entities");
       
       
       return factoryBean;
    }
    
    
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
