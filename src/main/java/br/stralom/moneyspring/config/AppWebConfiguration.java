/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.config;

import br.stralom.moneyspring.controllers.HomeController;
import br.stralom.moneyspring.controllers.TransactionController;
import br.stralom.moneyspring.dao.TransactionDAO;
import br.stralom.moneyspring.entities.Category;
import br.stralom.moneyspring.infra.FileSaver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Bruno Strano
 */
// Habilitando uso do Spring MVC
@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, TransactionDAO.class, FileSaver.class})
        //"web.xml" do spring
class AppWebConfiguration {
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        
        return resolver;
    }
    
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
        bundleMessageSource.setBasename("/WEB-INF/messages");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        bundleMessageSource.setCacheSeconds(1);
        
        return bundleMessageSource;
    }
    
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
    /**
    @Bean
    public FormattingConversionService conversionService(){
        DefaultFormattingConversionService defaultFormattingConversionService =
                new DefaultFormattingConversionService();
        
        DateFormatterRegistrar dateFormatterRegistrar = new DateFormatterRegistrar();
        dateFormatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
        dateFormatterRegistrar.registerFormatters(defaultFormattingConversionService);
        
        return defaultFormattingConversionService;
    }
    **/
}
