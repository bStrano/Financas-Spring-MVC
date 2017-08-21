 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.config;

import br.stralom.moneyspring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Bruno Strano
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CustomLogoutSucessHandler customLogoutSucessHandler;
    
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("userTest").password("teste").roles("USER","ADMIN");
        auth.userDetailsService(userDAO).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
           .antMatchers("/transactions/form").hasRole("USER")
            .antMatchers("/").permitAll()
             .antMatchers("/user/form").permitAll()
            .antMatchers("/resources/**").permitAll()
            .anyRequest().authenticated()
                .and().formLogin().loginPage("/user/login").permitAll()
                .and().csrf()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"));
      
        // logout
        // http://www.concretepage.com/spring-4/spring-4-security-custom-logoutsuccesshandler-example
        http.logout()
                .logoutUrl("/homeLogout")
                .logoutSuccessHandler(customLogoutSucessHandler);
                    
    }
    
    
}
