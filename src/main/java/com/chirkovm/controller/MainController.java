package com.chirkovm.controller;

import com.chirkovm.dao.ProductRepository;
import com.chirkovm.dao.PropertyRepository;
import com.chirkovm.model.Order;
import com.chirkovm.model.Product;
import com.chirkovm.service.*;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PricelistService pricelistService;

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public void showImg(@RequestParam(name = "id", required=true) Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        uploadService.getImage(id, response, request);
    }

    @RequestMapping(value = "/pdf", method = RequestMethod.GET)
    public void showPdf(@RequestParam(name = "id", required=true) Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        uploadService.getPdf(id, response, request);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndexPage(Model model, Principal principal, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response) throws ConfigurationException {
        addDefaultModels(model, request, response, bsessionid);
        model.addAttribute("topProducts", productService.getTopProducts());
        return "index";
    }
    @RequestMapping(value = "/how-to-buy", method = RequestMethod.GET)
    public String howToBuyPage(Model model, Principal principal, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response){
        addDefaultModels(model, request, response, bsessionid);
        return "how-to-buy";
    }
    @RequestMapping(value = "/delivery", method = RequestMethod.GET)
    public String deliveryPage(Model model, Principal principal, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response){
        addDefaultModels(model, request, response, bsessionid);
        return "delivery";
    }
    @RequestMapping(value = "/guarantees", method = RequestMethod.GET)
    public String guaranteesPage(Model model, Principal principal, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response){
        addDefaultModels(model, request, response, bsessionid);
        return "guarantees";
    }
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String aboutPage(Model model, Principal principal, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response){
        addDefaultModels(model, request, response, bsessionid);
        return "about";
    }

    @RequestMapping(value = "/modular-boiler", method = RequestMethod.GET)
    public String modularBoilerPage(Model model, Principal principal, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response){
    addDefaultModels(model, request, response, bsessionid);
        return "modular-boiler";
    }

    @RequestMapping(value = "/chimneys", method = RequestMethod.GET)
    public String chimneysPage(Model model, Principal principal, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response){
        addDefaultModels(model, request, response, bsessionid);
        return "chimneys";
    }

    @RequestMapping(value = "/pricelists", method = RequestMethod.GET)
    public String pricelistPage(Model model, Principal principal, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response){
        addDefaultModels(model, request, response, bsessionid);
        model.addAttribute("pricelists", pricelistService.getAllPricelists());
        return "pricelists";
    }


    @RequestMapping( value = "/admin", method = RequestMethod.GET)
    public String showLoginPage(@RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "logout", required = false) String logout,
                                @RequestParam(value = "registr_success", required = false) String registr_success,
                                Model flag) {
        flag.addAttribute("error", error != null);
        flag.addAttribute("logout", logout != null);
        flag.addAttribute("registr_success", registr_success != null);
        return "admin\\login";
    }

    public Model addDefaultModels(Model model, HttpServletRequest request, HttpServletResponse response, String bsessionid){
        model.addAttribute("orderInfo", clientService.checkClient(bsessionid, request, response).getOrderedProducts().size());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("hotProduct", productService.getHotProduct());
        return model;
    }
}