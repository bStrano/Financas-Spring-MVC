/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.dao;

import br.stralom.moneyspring.entities.Balance;
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
public class BalanceDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Balance> findAll(){
        String jpql = "select b from Balance b";
        TypedQuery<Balance> queryBalance = em.createQuery(jpql, Balance.class);
        return queryBalance.getResultList();
    }
}
