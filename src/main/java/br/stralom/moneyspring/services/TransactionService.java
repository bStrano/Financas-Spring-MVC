/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.stralom.moneyspring.services;

import br.stralom.moneyspring.dao.TransactionDAO;
import br.stralom.moneyspring.entities.Transaction;
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
    
    public List<Transaction> findAll(){
       return traDAO.showAll();
    }
    
}
