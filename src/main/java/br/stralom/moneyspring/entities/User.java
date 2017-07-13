/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private List<Balance> user_balances = new ArrayList<>();

    public User() {
    }

    public User(String user_name, String user_password, String user_email, List<Balance> user_balances) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_balances = user_balances;
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

    public List<Balance> getUser_balances() {
        return user_balances;
    }

    public void setUser_balances(List<Balance> user_balances) {
        this.user_balances = user_balances;
    }
    

    
    
    
}
