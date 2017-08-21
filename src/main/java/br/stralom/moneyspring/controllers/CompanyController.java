/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.controllers;

import br.stralom.moneyspring.dao.CompanyDAO;
import br.stralom.moneyspring.entities.Company;
import br.stralom.moneyspring.entities.User;
import br.stralom.moneyspring.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Bruno Strano
 */
@Controller
@RequestMapping("/transactions/companies")
public class CompanyController {

    @Autowired
    private CompanyService comSVC;
    
    @RequestMapping("/form")
    public String formCompany(Company company) {
        return "transactions/companies/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveCompany(@AuthenticationPrincipal User user, Company company) {
        comSVC.save(user, company);
        return "transactions/ok";
    }
}
