/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.stralom.moneyspring.services;

import br.stralom.moneyspring.dao.CompanyDAO;
import br.stralom.moneyspring.entities.Company;
import br.stralom.moneyspring.entities.User;
import java.util.List;
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
public class CompanyService {

    @Autowired
    private CompanyDAO comDAO;
    
    public void save(User user, Company com){
        com.setCom_user(user);
        comDAO.save(com);
    }
    
    public List<Company> findAll(Long userId){
        return comDAO.findAll();
    }
    
}
