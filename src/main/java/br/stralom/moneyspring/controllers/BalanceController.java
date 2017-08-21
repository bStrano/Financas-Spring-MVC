/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.controllers;

import br.stralom.moneyspring.dao.BalanceDAO;
import br.stralom.moneyspring.entities.Balance;
import br.stralom.moneyspring.entities.User;
import br.stralom.moneyspring.services.BalanceService;
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
    private BalanceService balSVC;
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Balance balance){
       return "balances/form";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String save(@AuthenticationPrincipal User user, Balance balance){
        balSVC.save(user, balance);
        return "home";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(@AuthenticationPrincipal User user){
        ModelAndView modelAndView = new ModelAndView("balances/list");
        modelAndView.addObject("listBalance", balSVC.getAll(user.getUser_id()));
        return modelAndView;
        
    }
    
}
