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
    @NotNull
    private BigDecimal tra_value;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Calendar tra_date = Calendar.getInstance();
    @Enumerated(EnumType.STRING)
    @NotNull
    private TypeTransaction tra_typeTransaction;
    private String tra_invoicePath;
    private int tra_numInstalments = 1;
    @Transient
    private int tra_numInstalmentsRemaining = tra_numInstalments;
    
    @ManyToOne
    @JoinColumn(name="tra_company")
    private Company tra_company;
    
    @OneToMany(mappedBy = "ins_transaction")
    private Collection<Instalment> tra_instalments = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="tra_balance")
    @NotNull
    private Balance tra_balance;
    
    @ManyToMany
    @JoinTable(
        name = "tb_transactions_category",joinColumns=
        {@JoinColumn(name="tra_id")},inverseJoinColumns = 
        {@JoinColumn(name="cat_id")})
    private Set<Category> tra_categories = new HashSet<>();

    public Transaction(Long tra_id, String tra_name, BigDecimal tra_value, TypeTransaction tra_typeTransaction, Balance tra_balance) {
        this.tra_id = tra_id;
        this.tra_name = tra_name;
        this.tra_value = tra_value;
        this.tra_typeTransaction = tra_typeTransaction;
        this.tra_balance = tra_balance;
    }

    


    
    
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

    public Balance getTra_balance() {
        return tra_balance;
    }

    public void setTra_balance(Balance tra_balance) {
        this.tra_balance = tra_balance;
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
    
    public List<Transaction> listWithInstalments(){
        
        return null;
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
        if (!Objects.equals(this.tra_id, other.tra_id)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Transaction{" + "tra_id=" + tra_id + ", tra_name=" + tra_name + ", tra_desc=" + tra_desc + ", tra_value=" + tra_value + ", tra_date=" + tra_date + ", tra_typeTransaction=" + tra_typeTransaction + ", tra_invoicePath=" + tra_invoicePath + ", tra_numInstalments=" + tra_numInstalments + ", tra_numInstalmentsRemaining=" + tra_numInstalmentsRemaining + ", tra_company=" + tra_company + ", tra_instalments=" + tra_instalments + ", tra_balance=" + tra_balance + ", tra_categories=" + tra_categories + '}';
    }

    

    
 

    
    
   
}
