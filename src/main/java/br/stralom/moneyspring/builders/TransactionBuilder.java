/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.builders;

import br.stralom.moneyspring.entities.Balance;
import br.stralom.moneyspring.entities.Category;
import br.stralom.moneyspring.entities.Company;
import br.stralom.moneyspring.entities.Instalment;
import br.stralom.moneyspring.entities.Transaction;
import br.stralom.moneyspring.entities.TypeTransaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Bruno Strano
 */
public class TransactionBuilder {


    public TransactionBuilder() {
    }

    public Transaction build(Balance bal){
        Transaction tra = new Transaction();
        tra.setTra_name("Transaction Teste" );
        tra.setTra_desc("Transaction Desc Teste");
        tra.setTra_balance(bal);
        tra.setTra_value(BigDecimal.ZERO);
        tra.setTra_typeTransaction(TypeTransaction.ENTRADA);
        return tra;
    }
    
    
}
