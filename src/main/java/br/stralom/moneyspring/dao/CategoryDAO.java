/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.dao;

import br.stralom.moneyspring.entities.Category;
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
public class CategoryDAO {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Category> findAll(Long id){
        String jpql = "select c from Category c "
                + "where c.cat_user.user_id = :pUserId ";
        TypedQuery<Category> queryCategory = em.createQuery(jpql, Category.class);
        queryCategory.setParameter("pUserId", id);
        List<Category> categoryList = queryCategory.getResultList();
        return categoryList;
    }
    
    public Category findByName(String name, Long id){
        String jpql = "select c from Category c "
                + " where c.cat_name = :pName "
                + "and where c.cat_user.user_id = :pUserId " ;
        TypedQuery<Category> catQuery = em.createQuery(jpql, Category.class);
        catQuery.setParameter("pName", name);
        catQuery.setParameter("pUserId", id);
        return catQuery.getSingleResult();
    }
    
    
    
    public void save(Category cat){
        em.persist(cat);
    }
    
    public Category find(Long id){
        return em.find(Category.class, id);
    }
    
    public Category findById(Long id){
        String jpql = "select c from Category c where c.cat_id = :pId";
        TypedQuery query = em.createQuery(jpql, Category.class);
        query.setParameter("pId", id);
        return (Category) query.getSingleResult();
    }
    
    public void merge(Category category){
        em.merge(category);
    }
    
}
