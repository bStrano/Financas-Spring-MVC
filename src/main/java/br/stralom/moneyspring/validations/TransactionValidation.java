/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.validations;

import br.stralom.moneyspring.entities.Transaction;
import java.util.Calendar;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Bruno Strano
 */
public class TransactionValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // Verifica se a classe recebida no parametro é de fato uma Transaction.
        // O Spring vai verificar se o objeto recebido é instancia da classe Transaction
        return Transaction.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"tra_name","field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tra_desc", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tra_value", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tra_typeTransaction", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tra_date", "field.required");
        
       Transaction transaction = (Transaction) target;
       System.out.println(transaction.getTra_date().get(Calendar.YEAR));
        if( (transaction.getTra_date().get(Calendar.YEAR) > 2200) || (transaction.getTra_date().get(Calendar.DAY_OF_MONTH) > 31 )|| (transaction.getTra_date().get(Calendar.MONTH) > 12) ){
            
        
            errors.rejectValue("tra_date", "invalid.input");
        }
        
        
        //ValidationUtils.rejectIfEmpty(errors, "tra_categories", "field.required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tra_value", "field.required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tra_name", "field.required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tra_desc", "field.required");
    }

}
