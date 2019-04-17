package com.chirkovm.controller;

import com.chirkovm.model.Order;
import com.chirkovm.model.Product;
import com.chirkovm.service.CategoryService;
import com.chirkovm.service.ClientService;
import com.chirkovm.service.OrderService;
import com.chirkovm.service.ProductService;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.weaver.patterns.OrSignaturePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Michael Chirkov on 09.12.2017.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ClientService clientService;

    //todo
    @RequestMapping(value = "/category/{categoryId}/product/{productId}", method = RequestMethod.GET)
    public String showProductInfo(Model model, @PathVariable("productId") int productId, @PathVariable("categoryId") int categoryId,
                                  @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("orderInfo", clientService.checkClient(bsessionid, request, response).getOrderedProducts().size());
        model.addAttribute("product", productService.getById(productId));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("sparPartsSize",productService.getById(productId).getSparParts().size());
        model.addAttribute("hotProduct", productService.getHotProduct());
        Product product = new Product();
        return "/product-one";
    }

    @RequestMapping(value = "/spar-parts", method = RequestMethod.GET)
    public String showSparParts(Model model, @RequestParam(name = "product", required = false) Integer productId,
                                @RequestParam(name = "category", required = false) Integer categoryId,
                                @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response){

        model = productService.getSparPart(categoryId,productId, model);
        model.addAttribute("orderInfo", clientService.checkClient(bsessionid, request, response).getOrderedProducts().size());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("hotProduct", productService.getHotProduct());
        return "spar-parts";
    }


}
