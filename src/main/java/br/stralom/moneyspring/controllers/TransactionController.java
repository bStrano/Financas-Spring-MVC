/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.controllers;

import br.stralom.moneyspring.dao.BalanceDAO;
import br.stralom.moneyspring.dao.CategoryDAO;
import br.stralom.moneyspring.dao.CompanyDAO;
import br.stralom.moneyspring.dao.InstalmentDAO;
import br.stralom.moneyspring.dao.TransactionDAO;
import br.stralom.moneyspring.entities.Balance;
import br.stralom.moneyspring.entities.Category;
import br.stralom.moneyspring.entities.Company;
import br.stralom.moneyspring.entities.Instalment;
import br.stralom.moneyspring.entities.Transaction;
import br.stralom.moneyspring.form.TransactionForm;
import br.stralom.moneyspring.infra.FileSaver;
import br.stralom.moneyspring.validations.TransactionValidation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Bruno Strano
 */
@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionDAO traDAO;
    @Autowired
    private CompanyDAO comDAO;
    @Autowired
    private CategoryDAO catDAO;
    @Autowired
    private InstalmentDAO insDAO;
    @Autowired
    private BalanceDAO balDAO;
    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    // O Binder, é responsavel por conectar  duas coisas. Por exemplo os dados do
    // formulário com o objeto da classe Transaction.
    public void InitBinder(WebDataBinder binder) {

        //binder.addValidators(new TransactionValidation());
    }

    
    @RequestMapping("/form")
    public ModelAndView form(TransactionForm transactionForm) {
        ModelAndView modelAndView = new ModelAndView("transactions/form");
        List<Category> listCategory = catDAO.findAll();
        modelAndView.addObject("listCategory", listCategory);
        List<Company> listCompany = comDAO.findAll();
        modelAndView.addObject("listCompany", listCompany);
        List<Balance> listBalance =  balDAO.findAll();
        modelAndView.addObject("listBalance", listBalance);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save( MultipartFile invoice, @Valid TransactionForm transactionForm, BindingResult result, RedirectAttributes redirectAttributes) { 
 
        if (result.hasErrors()) {
            System.out.println(result.getErrorCount());
            System.out.println(result.getAllErrors());
            return form(transactionForm);
        }
        Transaction transaction = transactionForm.build();
        
        
        String path= fileSaver.write("/archives", invoice);
        transaction.setTra_invoicePath(path);
        System.out.println("Informações da Transação : " + transaction);
        traDAO.gravar(transaction);
        for (Instalment tra_instalment : transaction.getTra_instalments()) {
            tra_instalment.setIns_transaction(transaction);
            insDAO.save(tra_instalment);
            //System.out.println(tra_instalment);
            
        }
        
        redirectAttributes.addFlashAttribute("sucess", "Transação adicionada com sucesso"); 
        return new ModelAndView("redirect:transactions");
     
      }
   
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("transactions/list");
        //List<Transaction> listTra = traDAO.showAll();
        List<Transaction> listTra = traDAO.findAllWithInstalment();

        //System.out.println("Transactions sem Parcela: " + traDAO.findAll());
        Collections.sort(listTra, Comparator.comparing(Transaction::getTra_date).reversed());
        modelAndView.addObject("listTransaction", listTra);
        return modelAndView;
    }

    /**
    @RequestMapping(value="/info", method = RequestMethod.POST)
    public ModelAndView info(String name){
        System.out.println("test");
        
        String saida = "transactions/info2/"+name;
        System.out.println(saida);
        //return saida;
        return new ModelAndView(saida);
    }
    **/
    
    @RequestMapping("/info")
    public ModelAndView infoTest(@RequestParam("name") String name){
        System.out.println(name);
        ModelAndView modelAndView = new ModelAndView("transactions/info");
        Transaction transaction = traDAO.findByName(name);
        modelAndView.addObject("tra", transaction);
        return modelAndView;
    }
    
    

    @RequestMapping("/categories/form")
    public String formCategory() {

        return "transactions/categories/form";
    }

    @RequestMapping("/categories")
    public String saveCategory(Category cat) {
        System.out.println(cat);
        catDAO.save(cat);
        return "transactions/ok";
    }

    @RequestMapping("/companies/form")
    public String formCompany() {
        return "transactions/companies/form";
    }

    @RequestMapping("companies")
    public String saveCompany(Company company) {
        comDAO.save(company);
        return "transactions/ok";
    }
}
