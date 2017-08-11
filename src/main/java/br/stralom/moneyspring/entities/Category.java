/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bruno Strano
 */
@Entity
@Table(name="tb_category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cat_id;

    private String cat_name;
    @ManyToMany(mappedBy="tra_categories")
    private Set<Transaction> cat_transactions = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User cat_user;
    
    public Category() {
    }

    public Category(Long cat_id, String cat_name) {
        this.cat_id = cat_id;
        this.cat_name = cat_name;
    }

 
    

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    // List READ-ONLY, for add use addTransaction.
    public Set<Transaction> getCat_transactions() {
   //     return Collections.unmodifiableList(cat_transactions);
       return cat_transactions;
    }
    
    public void addTransaction(Transaction transaction){
        this.cat_transactions.add(transaction);
    }

    public void setCat_transactions(Set<Transaction> cat_transactions) {
        this.cat_transactions = cat_transactions;
    }

    public User getCat_user() {
        return cat_user;
    }

    public void setCat_user(User cat_user) {
        this.cat_user = cat_user;
    }


    
    
    @Override
    public String toString() {
        return cat_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cat_id);
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
        final Category other = (Category) obj;
        if (!Objects.equals(this.cat_name, other.cat_name)) {
            return false;
        }
        if (!Objects.equals(this.cat_id, other.cat_id)) {
            return false;
        }
        if (!Objects.equals(this.cat_transactions, other.cat_transactions)) {
            return false;
        }
        return true;
    }

   



    
    

    
}
