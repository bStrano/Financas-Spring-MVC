/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Bruno Strano
 */
@Entity
public class Role implements GrantedAuthority{
    private static final long serialVersionUID = 1L;
    
    
    @Id
    private String role_name;
    @ManyToMany(mappedBy="user_roles")
    private List<User> role_users = new ArrayList<>();
    public String getRol_name() {
        return role_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<User> getRole_users() {
        return role_users;
    }

    public void setRole_users(List<User> role_users) {
        this.role_users = role_users;
    }

   
    
    
    @Override
    public String getAuthority() {
        return this.role_name;
    }

    @Override
    public String toString() {
        return "Role{" + "role_name=" + role_name + '}';
    }
    
    
    
}
