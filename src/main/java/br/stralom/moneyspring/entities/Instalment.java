/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Bruno Strano
 */
@Entity
@Table(name = "tb_instalment")
public class Instalment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ins_id;
    private BigDecimal ins_value;
    private BigDecimal ins_interestRate;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar ins_date;
    @ManyToOne
    @JoinColumn(name = "ins_transaction")
    private Transaction ins_transaction;
    private int ins_number;

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

    public Transaction getIns_transaction() {
        return ins_transaction;
    }

    public void setIns_transaction(Transaction ins_transaction) {
        this.ins_transaction = ins_transaction;
    }

    public Calendar getIns_date() {
        return ins_date;
    }

    public void setIns_date(Calendar ins_date) {
        this.ins_date = ins_date;
    }


    public BigDecimal getIns_interestRate() {
        return ins_interestRate;
    }

    public void setIns_interestRate(BigDecimal ins_interestRate) {
        this.ins_interestRate = ins_interestRate;
    }

    public int getIns_number() {
        return ins_number;
    }

    public void setIns_number(int ins_number) {
        this.ins_number = ins_number;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.ins_id);
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
        final Instalment other = (Instalment) obj;
        if (!Objects.equals(this.ins_id, other.ins_id)) {
            return false;
        }
        if (!Objects.equals(this.ins_value, other.ins_value)) {
            return false;
        }
        if (!Objects.equals(this.ins_interestRate, other.ins_interestRate)) {
            return false;
        }
        if (!Objects.equals(this.ins_date, other.ins_date)) {
            return false;
        }
        if (!Objects.equals(this.ins_transaction, other.ins_transaction)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Instalment{" + "ins_id=" + ins_id + ", ins_value=" + ins_value + ", ins_interestRate=" + ins_interestRate + '}';
    }

}
