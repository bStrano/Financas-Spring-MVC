/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Bruno Strano
 */
@Entity
@Table(name="tb_goal")
public class Goal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goal_id;
    private String goal_name;
    private BigDecimal goal_value;
    private String goal_desc;
    private double goal_percentage;
    private String goal_imagePath;
    @ManyToOne
    @JoinColumn(name="goal_balance")
    private Balance goal_balance;

    public Long getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(Long goal_id) {
        this.goal_id = goal_id;
    }

    public String getGoal_name() {
        return goal_name;
    }

    public void setGoal_name(String goal_name) {
        this.goal_name = goal_name;
    }

    public BigDecimal getGoal_value() {
        return goal_value;
    }

    public void setGoal_value(BigDecimal goal_value) {
        this.goal_value = goal_value;
    }

    public String getGoal_desc() {
        return goal_desc;
    }

    public void setGoal_desc(String goal_desc) {
        this.goal_desc = goal_desc;
    }

    public double getGoal_percentage() {
        return goal_percentage;
    }

    public void setGoal_percentage(double goal_percentage) {
        this.goal_percentage = goal_percentage;
    }

    public String getGoal_imagePath() {
        return goal_imagePath;
    }

    public void setGoal_imagePath(String goal_imagePath) {
        this.goal_imagePath = goal_imagePath;
    }

    public Balance getGoal_balance() {
        return goal_balance;
    }

    public void setGoal_balance(Balance goal_balance) {
        this.goal_balance = goal_balance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.goal_id);
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
        final Goal other = (Goal) obj;
        if (Double.doubleToLongBits(this.goal_percentage) != Double.doubleToLongBits(other.goal_percentage)) {
            return false;
        }
        if (!Objects.equals(this.goal_name, other.goal_name)) {
            return false;
        }
        if (!Objects.equals(this.goal_desc, other.goal_desc)) {
            return false;
        }
        if (!Objects.equals(this.goal_imagePath, other.goal_imagePath)) {
            return false;
        }
        if (!Objects.equals(this.goal_id, other.goal_id)) {
            return false;
        }
        if (!Objects.equals(this.goal_value, other.goal_value)) {
            return false;
        }
        if (!Objects.equals(this.goal_balance, other.goal_balance)) {
            return false;
        }
        return true;
    }
    
    
}
