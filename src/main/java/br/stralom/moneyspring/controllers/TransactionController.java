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
import br.stralom.moneyspring.dao.UserDAO;
import br.stralom.moneyspring.entities.Balance;
import br.stralom.moneyspring.entities.Category;
import br.stralom.moneyspring.entities.Company;
import br.stralom.moneyspring.entities.Instalment;
import br.stralom.moneyspring.entities.Transaction;
import br.stralom.moneyspring.entities.User;
import br.stralom.moneyspring.form.TransactionForm;
import br.stralom.moneyspring.infra.FileSaver;
import br.stralom.moneyspring.services.BalanceService;
import br.stralom.moneyspring.services.CategoryService;
import br.stralom.moneyspring.services.CompanyService;
import br.stralom.moneyspring.services.InstalmentService;
import br.stralom.moneyspring.services.TransactionService;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private TransactionService traSVC;
    @Autowired
    private CompanyService comSVC;
    @Autowired
    private CategoryService catSVC;
    @Autowired
    private InstalmentService insSVC;
    @Autowired
    private BalanceService balSVC;
    @Autowired
    private FileSaver fileSaver;
    @Autowired
    private UserDAO userDAO;
    
    
    @InitBinder
    // O Binder, é responsavel por conectar  duas coisas. Por exemplo os dados do
    // formulário com o objeto da classe Transaction.
    public void InitBinder(WebDataBinder binder) {

        //binder.addValidators(new TransactionValidation());
    }

    
    @RequestMapping("/form")
    public ModelAndView form(@AuthenticationPrincipal User user, TransactionForm transactionForm) {
        ModelAndView modelAndView = new ModelAndView("transactions/form");
        modelAndView.addObject("listCategory", catSVC.findAll(user.getUser_id()));
        modelAndView.addObject("listCompany", comSVC.findAll(user.getUser_id()));
        modelAndView.addObject("listBalance", balSVC.findAll(user.getUser_id()));
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save( @AuthenticationPrincipal User user, MultipartFile invoice, @Valid TransactionForm transactionForm, BindingResult result, RedirectAttributes redirectAttributes) { 
        if (result.hasErrors()) {
//            System.out.println(result.getErrorCount());
//            System.out.println(result.getAllErrors());
            return form(user, transactionForm);
        }
        Transaction transaction = transactionForm.build();
        List<Instalment> instalments = traSVC.createInstalments(transaction.getTra_numInstalments(), transaction.getTra_date(), transaction.getTra_interestRate(), transaction.getTra_value());
        transaction.setTra_instalments(instalments);
        
        String path= fileSaver.write("/archives", invoice);
        transaction.setTra_invoicePath(path);
        traSVC.save(transaction);
        
        redirectAttributes.addFlashAttribute("sucess", "Transação adicionada com sucesso"); 
        return new ModelAndView("redirect:transactions");
     
      }
   
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAll( @AuthenticationPrincipal User user, @RequestParam("idBalance") Long idBalance ) {
        ModelAndView modelAndView = new ModelAndView("transactions/list");
        //List<Transaction> listTra = traDAO.showAll();
        //List<Instalment> listIns = insSVC.findAll(1L);
        //System.out.println("Transactions sem Parcela: " + traDAO.findAll());
        //Collections.sort(listIns, Comparator.comparing(Instalment::getIns_date).reversed());
        modelAndView.addObject("listInstalment", insSVC.findAll(user.getUser_id(),idBalance));
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
        modelAndView.addObject("tra", traSVC.findByName(name));
        return modelAndView;
    }

}
