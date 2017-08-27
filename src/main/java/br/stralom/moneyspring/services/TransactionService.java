/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.services;

import br.stralom.moneyspring.dao.InstalmentDAO;
import br.stralom.moneyspring.dao.TransactionDAO;
import br.stralom.moneyspring.entities.Instalment;
import br.stralom.moneyspring.entities.Transaction;
import br.stralom.moneyspring.infra.FileSaver;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruno Strano
 * @since 08/2017
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionDAO traDAO;
    @Autowired
    private InstalmentDAO insDAO;
    @Autowired
    private FileSaver fileSaver;
    @Autowired
    private InstalmentService insSVC;
    
    
    public void save(Transaction transaction) {
        traDAO.save(transaction);
        for (Instalment tra_instalment : transaction.getTra_instalments()) {
            tra_instalment.setIns_transaction(transaction);
            insDAO.save(tra_instalment);
        }
    }

    public List<Instalment> createInstalments(int numInstalments, Calendar initialDate, BigDecimal interestRate, BigDecimal totalValue){
        List<Instalment> instalments = new ArrayList<>();
        for(int i = 0 ; i < numInstalments ; i++){
            Instalment ins = new Instalment();
            ins.setIns_number(i+1);
            ins.setIns_date(insSVC.calcInsDate(i+1, initialDate));
            ins.setIns_value(insSVC.calcValue(totalValue, numInstalments, interestRate,i+1));
            instalments.add(ins);
        }
        return instalments;
    }
    
    public List<Transaction> findAll() {
        return traDAO.showAll();
    }

    public Transaction findByName(String name) {
        return traDAO.findByName(name);
    }

    public Transaction find(Long id){
        return traDAO.findById(id);
    }

}
