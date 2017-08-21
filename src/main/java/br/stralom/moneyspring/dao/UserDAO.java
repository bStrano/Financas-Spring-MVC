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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bruno Strano
 */
@Repository
public class UserDAO implements UserDetailsService{
    
    @PersistenceContext
    private EntityManager em;
    
   public User find(Long id){
        return em.find(User.class, id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String jpql = "select u from User u join fetch u.user_roles  where u.user_email = :pEmail";
        TypedQuery<User> userQuery = em.createQuery(jpql, User.class);
        userQuery.setParameter("pEmail", email);
        User user = userQuery.getSingleResult();
        
        if (user == null){
            throw new UsernameNotFoundException("O usuário " + email + " não foi encontrado.");
        }
        
        return user;
    }
    
        public void merge(User user) {
        em.merge(user);
    }
        
        public void save(User user){
            em.persist(user);
        }
}
