/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.controllers;

import br.stralom.moneyspring.dao.CategoryDAO;
import br.stralom.moneyspring.dao.TransactionDAO;
import br.stralom.moneyspring.entities.Category;
import br.stralom.moneyspring.entities.Transaction;
import br.stralom.moneyspring.infra.FileSaver;
import br.stralom.moneyspring.validations.TransactionValidation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private CategoryDAO catDAO;
    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    // O Binder, é responsavel por conectar  duas coisas. Por exemplo os dados do
    // formulário com o objeto da classe Transaction.
    public void InitBinder(WebDataBinder binder){

        binder.addValidators(new TransactionValidation());
        
    }
    
    @RequestMapping("/form")
    public ModelAndView form(Transaction transaction) {
        ModelAndView modelAndView = new ModelAndView("transactions/form");
        transaction.setTra_categories(new ArrayList<Category>());
        List<Category> listCategory = catDAO.findAll();
        modelAndView.addObject("listCategory", listCategory);
        return modelAndView;
    }

    @RequestMapping( method=RequestMethod.POST)
    public ModelAndView save(MultipartFile invoice, @Valid Transaction transaction,BindingResult result, RedirectAttributes redirectAttributes) {
//     List<Category> categorias = new ArrayList<>();
  //      categoria = catDAO.findByName(categoria.getCat_name());
    //    System.out.println(" ----------------------  :::::" +categoria);
      //  categorias.add(categoria);
        //transaction.setTra_categories(categorias);
        if(result.hasErrors()){
            System.out.println(result.getErrorCount());
            System.out.println(result.getAllErrors());
            return form(transaction);
        }
        System.out.println(invoice.getOriginalFilename());
        String path = fileSaver.write("/archives", invoice);
        transaction.setTra_invoicePath(path);
        System.out.println(transaction);
        traDAO.gravar(transaction);
        
        redirectAttributes.addFlashAttribute("sucess", "Transação adicionada com sucesso");
        return new ModelAndView("redirect:transactions");
        
    }

    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("transactions/list");
        List<Transaction> listTra = traDAO.showAll();
        for (Transaction transaction : listTra) {
            System.out.println("Transaction: " + transaction.getTra_categories());
        }
        modelAndView.addObject("listTransaction", listTra);
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

}
