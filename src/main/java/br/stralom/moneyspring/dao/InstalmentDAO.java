/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.dao;

import br.stralom.moneyspring.entities.Instalment;
import br.stralom.moneyspring.entities.Transaction;
import java.math.BigDecimal;
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
public class InstalmentDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Instalment> findAll(Long idBalance) {
        return em.createQuery("select i from Instalment i "
                + " join fetch i.ins_transaction t"
                + " join fetch t.tra_categories"
                + " where t.tra_balance.bal_id = :pBalance"
                + " ORDER BY i.ins_date DESC", Instalment.class).setParameter("pBalance", idBalance)
                .getResultList();
    }

    public void save(Instalment ins) {
        em.persist(ins);
    }
    
}
