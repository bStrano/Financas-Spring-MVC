/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.stralom.moneyspring.controllers;

import br.stralom.moneyspring.config.AppWebConfiguration;
import br.stralom.moneyspring.config.JPAConfiguration;
import br.stralom.moneyspring.entities.Category;
import static java.util.Arrays.asList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.mockito.Mockito;


/**
 *
 * @author Bruno Strano
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class, AppWebConfiguration.class})
@ActiveProfiles("test")
@WebAppConfiguration
public class TransactionControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    public TransactionControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void formTest() throws Exception{
        List<Category> expectedCategories = asList(new Category());
        mockMvc.perform(MockMvcRequestBuilders.get("/transactions/form"))
               // .andExpect(MockMvcResultMatchers.model().attribute("listCategory", expectedCategories))
                .andExpect(MockMvcResultMatchers.model().attributeExists("listBalance"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("listCompany"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/views/transactions/form.jsp"));
    }
    
    
}
