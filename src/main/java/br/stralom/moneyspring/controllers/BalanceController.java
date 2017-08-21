/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.controllers;

import br.stralom.moneyspring.dao.BalanceDAO;
import br.stralom.moneyspring.entities.Balance;
import br.stralom.moneyspring.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Bruno Strano
 */
@Controller
@RequestMapping("/balances")
public class BalanceController {
    
    @Autowired
    private BalanceDAO balDAO;
            
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Balance balance){
       return "balances/form";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String save(@AuthenticationPrincipal User user, Balance balance){
        balance.setBal_user(user);
        balDAO.save(balance);
        return "home";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(@AuthenticationPrincipal User user){
        List<Balance> balances = balDAO.findAll(user.getUser_id());
        ModelAndView modelAndView = new ModelAndView("balances/list");
        System.out.println(balances);
        modelAndView.addObject("listBalance", balances);
        return modelAndView;
        
    }
    
}
