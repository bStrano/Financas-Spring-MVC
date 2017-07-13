/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Bruno Strano
 */
@Entity
@Table(name="tb_transaction")
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tra_id;
    @NotNull
    private String tra_name;
    @NotNull
    private String tra_desc;
    private BigDecimal tra_value;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Calendar tra_date = Calendar.getInstance();
    @Enumerated(EnumType.STRING)
    private TypeTransaction tra_typeTransaction;
    private String tra_invoicePath;
    @ManyToOne
    @JoinColumn(name="tra_company")
    private Company tra_company;
    
    @ManyToMany(mappedBy="bal_transactions")
    private List<Balance> tra_balances = new ArrayList<>();
    
    @OneToMany(mappedBy = "ins_transaction")
    private List<Installment> tra_installments = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "tb_transactions_category",joinColumns=
        {@JoinColumn(name="tra_id")},inverseJoinColumns = 
        {@JoinColumn(name="cat_id")})
    private List<Category> tra_categories = new ArrayList<>();


    
    public Transaction() {
    }

    public Long getTra_id() {
        return tra_id;
    }

    public void setTra_id(Long tra_id) {
        this.tra_id = tra_id;
    }

    public String getTra_name() {
        return tra_name;
    }

    public void setTra_name(String tra_name) {
        this.tra_name = tra_name;
    }

    public String getTra_desc() {
        return tra_desc;
    }

    public void setTra_desc(String tra_desc) {
        this.tra_desc = tra_desc;
    }

    public BigDecimal getTra_value() {
        return tra_value;
    }

    public void setTra_value(BigDecimal tra_value) {
        this.tra_value = tra_value;
    }

    public Calendar getTra_date() {
        return tra_date;
    }

    public void setTra_date(Calendar tra_date) {
        this.tra_date = tra_date;
    }

    public TypeTransaction getTra_typeTransaction() {
        return tra_typeTransaction;
    }

    public void setTra_typeTransaction(TypeTransaction tra_typeTransaction) {
        this.tra_typeTransaction = tra_typeTransaction;
    }

    public String getTra_invoicePath() {
        return tra_invoicePath;
    }

    public void setTra_invoicePath(String tra_invoicePath) {
        this.tra_invoicePath = tra_invoicePath;
    }

    public Company getTra_company() {
        return tra_company;
    }

    public void setTra_company(Company tra_company) {
        this.tra_company = tra_company;
    }

    public List<Balance> getTra_balances() {
        return tra_balances;
    }

    public void setTra_balances(List<Balance> tra_balances) {
        this.tra_balances = tra_balances;
    }

    public List<Installment> getTra_installments() {
        return tra_installments;
    }

    public void setTra_installments(List<Installment> tra_installments) {
        this.tra_installments = tra_installments;
    }

    

    

    
    // READ-ONLY
    public List<Category> getTra_categories() {
        return this.tra_categories;
    }
    
    public void addCategory(Category category){
        this.tra_categories.add(category);
    }

    public void setTra_categories(List<Category> tra_categories) {
        this.tra_categories = tra_categories;
    }

    
    
    @Override
    public String toString() {
        return "Transaction{" + "tra_id=" + tra_id + ", tra_name=" + tra_name + ", tra_desc=" + tra_desc + ", tra_value=" + tra_value + ", tra_date=" + tra_date + ", tra_typeTransaction=" + tra_typeTransaction + ", tra_categories=" + tra_categories + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.tra_id);
        hash = 19 * hash + Objects.hashCode(this.tra_name);
        hash = 19 * hash + Objects.hashCode(this.tra_desc);
        hash = 19 * hash + Objects.hashCode(this.tra_value);
        hash = 19 * hash + Objects.hashCode(this.tra_date);
        hash = 19 * hash + Objects.hashCode(this.tra_typeTransaction);
        hash = 19 * hash + Objects.hashCode(this.tra_categories);
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
        final Transaction other = (Transaction) obj;
        if (!Objects.equals(this.tra_name, other.tra_name)) {
            return false;
        }
        if (!Objects.equals(this.tra_desc, other.tra_desc)) {
            return false;
        }
        if (!Objects.equals(this.tra_id, other.tra_id)) {
            return false;
        }
        if (!Objects.equals(this.tra_value, other.tra_value)) {
            return false;
        }
        if (!Objects.equals(this.tra_date, other.tra_date)) {
            return false;
        }
        if (this.tra_typeTransaction != other.tra_typeTransaction) {
            return false;
        }
        if (!Objects.equals(this.tra_categories, other.tra_categories)) {
            return false;
        }
        return true;
    }

    
    
   
}
