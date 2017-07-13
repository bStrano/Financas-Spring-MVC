/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.math.BigDecimal;
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
@Table(name="tb_installment")
public class Installment {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ins_id;
    private BigDecimal ins_value;
    @ManyToOne
    @JoinColumn(name="ins_transaction")
    private Transaction ins_transaction;
    
    public Long getIns_id() {
        return ins_id;
    }

    public void setIns_id(Long ins_id) {
        this.ins_id = ins_id;
    }

    public BigDecimal getIns_value() {
        return ins_value;
    }

    public void setIns_value(BigDecimal ins_value) {
        this.ins_value = ins_value;
    }
    
    
}
