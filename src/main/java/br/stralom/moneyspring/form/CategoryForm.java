/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.form;

import br.stralom.moneyspring.entities.Category;
import br.stralom.moneyspring.entities.Transaction;
import br.stralom.moneyspring.entities.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Bruno Strano
 */
public class CategoryForm {
    private String cat_name;
    private Long cat_user;

    public CategoryForm() {
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public Long getCat_user() {
        return cat_user;
    }

    public void setCat_user(Long cat_user) {
        this.cat_user = cat_user;
    }

    

    
    
    
    public Category build(){
        System.out.println("User Id" + cat_user);
        Category cat = new Category();
        cat.setCat_name(cat_name);
        User user = new User();
        user.setUser_id(cat_user);
        // find by email
        cat.setCat_user(user);
        return cat;
    }
}
