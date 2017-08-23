/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.form;

import br.stralom.moneyspring.entities.Balance;
import br.stralom.moneyspring.entities.Category;
import br.stralom.moneyspring.entities.Company;
import br.stralom.moneyspring.entities.Instalment;
import br.stralom.moneyspring.entities.Transaction;
import br.stralom.moneyspring.entities.TypeTransaction;
import br.stralom.moneyspring.services.InstalmentService;
import br.stralom.moneyspring.services.TransactionService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Bruno Strano
 */
public class TransactionForm {

    private String tra_name;
    private String tra_desc;
    private BigDecimal tra_value;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar tra_date = Calendar.getInstance();
    private TypeTransaction tra_typeTransaction;
    private String tra_invoicePath;
    private Set<Long> category_id = new HashSet<>();
    private Long company_id;
    private int tra_numInstalments;
    private BigDecimal ins_interestRate;
    private Long bal_id;
    private TransactionService traSVC =  new TransactionService();
    
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

    public Set<Long> getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Set<Long> category_id) {
        this.category_id = category_id;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public int getTra_numInstalments() {
        return tra_numInstalments;
    }

    public void setTra_numInstalments(int tra_numInstalments) {
        this.tra_numInstalments = tra_numInstalments;
    }

    public BigDecimal getIns_interestRate() {
        return ins_interestRate;
    }

    public void setIns_interestRate(BigDecimal ins_interestRate) {
        this.ins_interestRate = ins_interestRate;
    }

    public Long getBal_id() {
        return bal_id;
    }

    public void setBal_id(Long bal_id) {
        this.bal_id = bal_id;
    }
    
    

    public Transaction build() {
        Set<Category> categories = category_id.stream()
                .map(id -> new Category(id, ""))
                .collect(Collectors.toSet());

        Transaction transaction = new Transaction();
        transaction.setTra_name(tra_name);
        transaction.setTra_categories(categories);
        Company company = new Company();
        company.setCom_id(company_id);
        transaction.setTra_company(company);
        transaction.setTra_date(tra_date);
        transaction.setTra_desc(tra_desc);
        transaction.setTra_typeTransaction(tra_typeTransaction);
        transaction.setTra_value(tra_value);
        transaction.setTra_numInstalments(tra_numInstalments);
        transaction.setTra_instalments(traSVC.createInstalments(tra_numInstalments, transaction.getTra_date(), ins_interestRate, tra_value));
        Balance bal = new Balance();
        bal.setBal_id(bal_id);
        transaction.setTra_balance(bal);
        
        
        

        return transaction;
    }





}
