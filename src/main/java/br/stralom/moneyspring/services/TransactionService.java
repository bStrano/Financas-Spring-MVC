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

    public void save(Transaction transaction) {
        traDAO.save(transaction);
        for (Instalment tra_instalment : transaction.getTra_instalments()) {
            tra_instalment.setIns_transaction(transaction);
            insDAO.save(tra_instalment);
        }
    }

    public List<Transaction> findAll() {
        return traDAO.showAll();
    }

    public Transaction findByName(String name) {
        return traDAO.findByName(name);
    }



}
