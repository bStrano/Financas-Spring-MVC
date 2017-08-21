/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.controllers;

import br.stralom.moneyspring.dao.UserDAO;
import br.stralom.moneyspring.dao.UserDAOTest;
import br.stralom.moneyspring.entities.Role;
import br.stralom.moneyspring.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Bruno Strano
 */

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserDAOTest userDAOTest;
    
    public void InitBinder(WebDataBinder binder){
      //  binder.addValidators(new );
    }
    
    @RequestMapping(value="/login", method =RequestMethod.GET)
    public String login(){
        return "users/login";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(User user){
        return "users/form";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String save(User user){
        System.out.println(user.getPassword());
        user.setUser_password(new BCryptPasswordEncoder().encode(user.getUser_password()));
        List<Role> roles = user.getUser_roles();
        Role role = new Role();
        role.setRole_name("ROLE_USER");
        roles.add(role);
        user.setUser_roles(roles);
        userDAOTest.save(user);
        return "/home";
    }
}
