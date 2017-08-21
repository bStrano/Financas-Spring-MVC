/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.dao;

import br.stralom.moneyspring.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bruno Strano
 */
@Repository
@Transactional
public class UserDAOTest {
        @PersistenceContext
    private EntityManager em;
    
   public User find(Long id){
        return em.find(User.class, id);
    }

    
        public void merge(User user) {
        em.merge(user);
    }
        
        public void save(User user){
            em.persist(user);
        }
}

