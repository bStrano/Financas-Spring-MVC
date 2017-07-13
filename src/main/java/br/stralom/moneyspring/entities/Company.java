/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.util.ArrayList;
import java.util.List;
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
public class Company {
    private static final long serialVersionUID = 1L;
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long com_id;
   private String com_name;
   @OneToMany(mappedBy="tra_company")
   private List<Transaction> com_transactions = new ArrayList<>();
   
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

    public List<Transaction> getCom_transactions() {
        return com_transactions;
    }

    public void setCom_transactions(List<Transaction> com_transactions) {
        this.com_transactions = com_transactions;
    }
   
    
   
}
