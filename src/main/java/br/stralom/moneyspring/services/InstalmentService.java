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
        Calendar dateClone = (Calendar) ins_date.clone();
        dateClone.add(Calendar.DAY_OF_YEAR, ins_number*30);
        return dateClone;
    }

    public BigDecimal calcValue(BigDecimal totalValue, int numberOfInstalments, BigDecimal interestRate, int numberInstalment) {
        if (interestRate.equals(BigDecimal.ZERO)) {
            return calcSimpleValue(totalValue, numberOfInstalments, interestRate);
        } else {
            return calcValueWithCompundInterest(totalValue, numberInstalment,numberOfInstalments, interestRate);
        }

    }

    public BigDecimal calcSimpleValue(BigDecimal totalValue, int numberOfInstalments, BigDecimal interestRate) {
        return totalValue.divide(new BigDecimal(numberOfInstalments), 5, RoundingMode.HALF_UP);
    }

    public BigDecimal calcValueWithCompundInterest(BigDecimal totalValue, int numberInstalment, int numberOfInstalments, BigDecimal interestRate) {
        return totalValue.multiply(interestRate.pow(numberInstalment)).subtract(totalValue).add(calcSimpleValue(totalValue, numberOfInstalments, interestRate));
    }

//    //https://matematicabasica.net/juros-compostos/
//    public BigDecimal calcValueAbsolutCompoundInterest(BigDecimal initialCapital, BigDecimal interestRate, int numInstalments) {
//        return (initialCapital.multiply(BigDecimal.valueOf(1.0).add(interestRate).pow(numInstalments)));
//    }
}
