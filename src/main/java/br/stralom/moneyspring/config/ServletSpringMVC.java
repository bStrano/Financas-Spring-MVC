/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;




public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

    // Carregado ao iniciar o sistema
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //return new Class[] {RootConfiguration.class};
       return new Class[] { SecurityConfig.class, AppWebConfiguration.class, JPAConfiguration.class, CustomLogoutSucessHandler.class};
       //return new Class[] {SecurityConfiguration.class};
    }

    // Carregado ao acessar a aplicação
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter};
    }
    

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext); 
        servletContext.addListener(RequestContextListener.class);
        servletContext.setInitParameter("spring.profiles.active", "principal");
    }

    
    
}
