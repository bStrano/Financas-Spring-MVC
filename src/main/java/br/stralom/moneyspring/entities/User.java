/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno Strano
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @NotNull
    private String user_name;
    @NotNull
    private String last_name;
    @NotNull
    private String user_password;
    @NotNull
    private String user_email;
    @OneToMany(mappedBy = "bal_user")
    private Set<Balance> user_balances = new HashSet<>();

    public User() {
    }


    
    
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<Balance> getUser_balances() {
        return user_balances;
    }

    public void setUser_balances(Set<Balance> user_balances) {
        this.user_balances = user_balances;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.user_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.user_name, other.user_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.user_password, other.user_password)) {
            return false;
        }
        if (!Objects.equals(this.user_email, other.user_email)) {
            return false;
        }
        if (!Objects.equals(this.user_id, other.user_id)) {
            return false;
        }
        if (!Objects.equals(this.user_balances, other.user_balances)) {
            return false;
        }
        return true;
    }

    

    
    
    
}
