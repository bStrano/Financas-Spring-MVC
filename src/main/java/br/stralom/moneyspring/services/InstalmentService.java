/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.services;

import br.stralom.moneyspring.dao.InstalmentDAO;
import br.stralom.moneyspring.entities.Instalment;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruno Strano
 */
@Service
public class InstalmentService {

    @Autowired
    private InstalmentDAO insDAO;

    public List<Instalment> findAll(Long balanceID) {
        return insDAO.findAll(balanceID);
    }

    
    //https://matematicabasica.net/juros-compostos/
    public BigDecimal calcAbsolutCompoundInterest(BigDecimal initialCapital, BigDecimal interestRate, int numInstalments) {
        return (initialCapital.multiply(BigDecimal.valueOf(1.0).add(interestRate).pow(numInstalments)));
    }
}
