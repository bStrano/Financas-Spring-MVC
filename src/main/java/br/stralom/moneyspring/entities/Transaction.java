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
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
import javax.persistence.Transient;
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
    private String tra_desc;
    private BigDecimal tra_value;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Calendar tra_date = Calendar.getInstance();
    @Enumerated(EnumType.STRING)
    private TypeTransaction tra_typeTransaction;
    private String tra_invoicePath;
    private int tra_numInstalments;
    @Transient
    private int tra_numInstalmentsRemaining = -1;
    
    @ManyToOne
    @JoinColumn(name="tra_company")
    private Company tra_company;
    
    @OneToMany(mappedBy = "ins_transaction")
    private Collection<Instalment> tra_instalments = new ArrayList<>();
    
    @ManyToMany(mappedBy="bal_transactions", cascade = CascadeType.ALL)
    private Set<Balance> tra_balances = new HashSet<>();
    
    @ManyToMany
    @JoinTable(
        name = "tb_transactions_category",joinColumns=
        {@JoinColumn(name="tra_id")},inverseJoinColumns = 
        {@JoinColumn(name="cat_id")})
    private Set<Category> tra_categories = new HashSet<>();


    
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

    public Collection<Instalment> getTra_instalments() {
        return tra_instalments;
    }

    public void setTra_instalments(Collection<Instalment> tra_instalments) {
        this.tra_instalments = tra_instalments;
    }

    public Set<Balance> getTra_balances() {
        return tra_balances;
    }

    public void setTra_balances(Set<Balance> tra_balances) {
        this.tra_balances = tra_balances;
    }

    public Set<Category> getTra_categories() {
        return tra_categories;
    }

    public void setTra_categories(Set<Category> tra_categories) {
        this.tra_categories = tra_categories;
    }
    
    public void addCategory(Category category){
        this.tra_categories.add(category);
    }

    public int getTra_numInstalments() {
        return tra_numInstalments;
    }

    public void setTra_numInstalments(int tra_numInstalments) {
        this.tra_numInstalments = tra_numInstalments;
    }

    public int getTra_numInstalmentsRemaining() {
        return tra_numInstalmentsRemaining;
    }

    public void setTra_numInstalmentsRemaining(int tra_numInstalmentsRemaining) {
        this.tra_numInstalmentsRemaining = tra_numInstalmentsRemaining;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.tra_id);
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
        if (!Objects.equals(this.tra_invoicePath, other.tra_invoicePath)) {
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
        if (!Objects.equals(this.tra_company, other.tra_company)) {
            return false;
        }
        if (!Objects.equals(this.tra_instalments, other.tra_instalments)) {
            return false;
        }
        if (!Objects.equals(this.tra_balances, other.tra_balances)) {
            return false;
        }
        if (!Objects.equals(this.tra_categories, other.tra_categories)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaction{" + "tra_id=" + tra_id + ", tra_name=" + tra_name + ", tra_desc=" + tra_desc + ", tra_value=" + tra_value + ", tra_typeTransaction=" + tra_typeTransaction + ", tra_invoicePath=" + tra_invoicePath + ", tra_numInstalments=" + tra_numInstalments + ", tra_company=" + tra_company + ", tra_installments=" + tra_instalments + ", tra_balances=" + tra_balances + ", tra_categories=" + tra_categories + '}';
    }

    
 

    
    
   
}
