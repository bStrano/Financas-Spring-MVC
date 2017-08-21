/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.stralom.moneyspring.services;

import br.stralom.moneyspring.dao.CategoryDAO;
import br.stralom.moneyspring.entities.Category;
import br.stralom.moneyspring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Bruno Strano 
 * @since 08/2017
 */
@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryDAO catDAO;
    
    public void save(User user,Category cat){
        cat.setCat_user(user);
        catDAO.save(cat);
    }
}
