package com.chirkovm.controller;

import com.chirkovm.model.Order;
import com.chirkovm.service.CategoryService;
import com.chirkovm.service.ClientService;
import com.chirkovm.service.OrderService;
import com.chirkovm.service.ProductService;
import lombok.AllArgsConstructor;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Michael Chirkov on 19.11.2017.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public String showCategoryPage(Model model, @PathVariable("categoryId") int categoryId, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("orderInfo", clientService.checkClient(bsessionid, request, response).getOrderedProducts().size());
        model.addAttribute("products", productService.getAllProductsByCategory(categoryService.getById(categoryId)));
        model.addAttribute("category", categoryService.getById(categoryId));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("hotProduct", productService.getHotProduct());
    return "category-page";
    }
}
