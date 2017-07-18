/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruno Strano
 */
@Entity
@Table(name="tb_balance")
public class Balance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bal_id;
    private BigDecimal bal_total;
    private String bal_name;
    private String bal_desc;
    @Enumerated(EnumType.STRING)
    private BalanceStatus bal_BalanceStatus;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="tb_balance_transactions", 
            joinColumns = {@JoinColumn(name="bal_id")},
            inverseJoinColumns = {@JoinColumn(name="tra_id")})
    private Collection<Transaction> bal_transactions = new ArrayList<>();
    @OneToMany(mappedBy = "goal_balance")
    private Collection<Goal> bal_goals ;
    @ManyToOne
    @JoinColumn(name="bal_user")
    private User bal_user;
    
    
    public enum BalanceStatus {
        NEGATIVE,POSITIVE,NEUTRAL
    }

    public Long getBal_id() {
        return bal_id;
    }

    public void setBal_id(Long bal_id) {
        this.bal_id = bal_id;
    }

    public BigDecimal getBal_total() {
        return bal_total;
    }

    public void setBal_total(BigDecimal bal_total) {
        this.bal_total = bal_total;
    }

    public String getBal_name() {
        return bal_name;
    }

    public void setBal_name(String bal_name) {
        this.bal_name = bal_name;
    }

    public String getBal_desc() {
        return bal_desc;
    }

    public void setBal_desc(String bal_desc) {
        this.bal_desc = bal_desc;
    }

    public BalanceStatus getBal_BalanceStatus() {
        return bal_BalanceStatus;
    }

    public void setBal_BalanceStatus(BalanceStatus bal_BalanceStatus) {
        this.bal_BalanceStatus = bal_BalanceStatus;
    }

    public Collection<Transaction> getBal_transactions() {
        return bal_transactions;
    }

    public void setBal_transactions(Collection<Transaction> bal_transactions) {
        this.bal_transactions = bal_transactions;
    }


   


    public Collection<Goal> getBal_goals() {
        return bal_goals;
    }

    public void setBal_goals(Collection<Goal> bal_goals) {
        this.bal_goals = bal_goals;
    }

    public User getBal_user() {
        return bal_user;
    }

    public void setBal_user(User bal_user) {
        this.bal_user = bal_user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.bal_id);
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
        final Balance other = (Balance) obj;
        if (!Objects.equals(this.bal_name, other.bal_name)) {
            return false;
        }
        if (!Objects.equals(this.bal_desc, other.bal_desc)) {
            return false;
        }
        if (!Objects.equals(this.bal_id, other.bal_id)) {
            return false;
        }
        if (!Objects.equals(this.bal_total, other.bal_total)) {
            return false;
        }
        if (this.bal_BalanceStatus != other.bal_BalanceStatus) {
            return false;
        }
        if (!Objects.equals(this.bal_transactions, other.bal_transactions)) {
            return false;
        }
        if (!Objects.equals(this.bal_goals, other.bal_goals)) {
            return false;
        }
        if (!Objects.equals(this.bal_user, other.bal_user)) {
            return false;
        }
        return true;
    }
     
}
