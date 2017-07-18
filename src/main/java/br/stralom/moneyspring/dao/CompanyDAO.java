/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.dao;

import br.stralom.moneyspring.entities.Category;
import br.stralom.moneyspring.entities.Company;
import java.util.Collection;
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
public class CompanyDAO {
    @PersistenceContext
    private EntityManager em;
    
    public List<Company> findAll(){
        String jpql = "select c from Company c";
        TypedQuery<Company> queryCompany = em.createQuery(jpql, Company.class);
        
        return queryCompany.getResultList();
        
    }
    
    

    public void save(Company com) {
        em.persist(com);
    }
}
