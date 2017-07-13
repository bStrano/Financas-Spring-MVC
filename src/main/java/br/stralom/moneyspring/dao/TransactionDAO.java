/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.dao;

import br.stralom.moneyspring.entities.Transaction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bruno Strano
 */

@Repository
@Transactional
public class TransactionDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public void gravar(Transaction transaction){
        em.persist(transaction);
    }
    
    public List<Transaction> showAll(){
        String jpql = "select distinct t from Transaction t join fetch t.tra_categories";
        TypedQuery<Transaction> traQuery = em.createQuery(jpql, Transaction.class);
        return traQuery.getResultList();
    }
    
}
