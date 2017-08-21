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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruno Strano
 */
@Entity
@Table(name="tb_company")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long com_id;
   private String com_name;
   @OneToMany(mappedBy="tra_company")
   private Set<Transaction> com_transactions = new HashSet<>();
   @ManyToOne @JoinColumn(name="user_id")
   private User com_user;
   
    public Company() {
    }

    public Company(Long com_id) {
        this.com_id = com_id;
    }
   
   
   
    public Long getCom_id() {
        return com_id;
    }

    public void setCom_id(Long com_id) {
        this.com_id = com_id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public Set<Transaction> getCom_transactions() {
        return com_transactions;
    }

    public void setCom_transactions(Set<Transaction> com_transactions) {
        this.com_transactions = com_transactions;
    }

    public User getCom_user() {
        return com_user;
    }

    public void setCom_user(User com_user) {
        this.com_user = com_user;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.com_id);
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
        final Company other = (Company) obj;
        if (!Objects.equals(this.com_name, other.com_name)) {
            return false;
        }
        if (!Objects.equals(this.com_id, other.com_id)) {
            return false;
        }
        if (!Objects.equals(this.com_transactions, other.com_transactions)) {
            return false;
        }
        return true;
    }

    
    
   
}
