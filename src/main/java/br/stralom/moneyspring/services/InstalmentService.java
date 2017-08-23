/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.services;

import br.stralom.moneyspring.dao.InstalmentDAO;
import br.stralom.moneyspring.entities.Instalment;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
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

    public Calendar calcInsDate(int ins_number, Calendar ins_date) {
        int days = ins_number*30;
        ins_date.add(Calendar.DAY_OF_MONTH,days);
        return ins_date;
    }

    public BigDecimal calcValue(BigDecimal interestRate,  int numberOfInstalments, BigDecimal totalValue) {
        if (interestRate.equals(BigDecimal.ZERO)) {
            return calcSimpleValue(interestRate, numberOfInstalments, totalValue);
        } else {
            return calcValueWithCompundInterest(interestRate, numberOfInstalments, totalValue);
        }

    }

    public BigDecimal calcSimpleValue(BigDecimal totalValue, int numberOfInstalments, BigDecimal interestRate) {
        return totalValue.divide(new BigDecimal(numberOfInstalments), 5, RoundingMode.HALF_UP);
    }

    public BigDecimal calcValueWithCompundInterest(BigDecimal totalValue, int numberOfInstalments, BigDecimal interestRate ){
        return totalValue.multiply(interestRate.pow(numberOfInstalments));
    }
    
//    //https://matematicabasica.net/juros-compostos/
//    public BigDecimal calcValueAbsolutCompoundInterest(BigDecimal initialCapital, BigDecimal interestRate, int numInstalments) {
//        return (initialCapital.multiply(BigDecimal.valueOf(1.0).add(interestRate).pow(numInstalments)));
//    }
}
