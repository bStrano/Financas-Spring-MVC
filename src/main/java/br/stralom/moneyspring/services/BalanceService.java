/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.stralom.moneyspring.services;

import br.stralom.moneyspring.dao.BalanceDAO;
import br.stralom.moneyspring.entities.Balance;
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
public class BalanceService {

    @Autowired
    private BalanceDAO balDAO;
    
    public void save(User user, Balance bal) {
        bal.setBal_user(user);
        balDAO.save(bal);
    }
    
    public List<Balance> findAll(Long userId){
        return balDAO.findAll(userId);
    }
}
