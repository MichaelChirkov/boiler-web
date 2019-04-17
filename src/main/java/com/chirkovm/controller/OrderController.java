package com.chirkovm.controller;


import com.chirkovm.model.Order;
import com.chirkovm.model.OrderCountDto;
import com.chirkovm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Michael Chirkov on 09.12.2017.
 */
@Controller
public class OrderController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderedProductService orderedProductService;


    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showOrderPage(HttpServletResponse res,@CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, Model model,
                                @RequestParam(name = "success", required = false) String success, HttpServletResponse response){
        Order order = clientService.checkClient(bsessionid, request, response);
       addDefaultModels(model, order);
        model.addAttribute("success", success ==null ? null : true );
        model.addAttribute("orPrTotalCount", orderService.getOrderedProductsTotalCount(order));

        return "order";

    }

    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    public String addProductToOrder(@CookieValue("BSESSIONID") String bsessionid, HttpServletRequest request, Model model,
                                    @RequestParam(name = "product", required = false) Integer productId, HttpServletResponse response){
        Order order = clientService.checkClient(bsessionid, request, response);
        orderService.addNewProductToOrder(productId, order);
        addDefaultModels(model, order);
        model.addAttribute("success", "success");
        return "redirect:" + request.getHeader("referer");
    }

    @RequestMapping(value = "/order/clean-all", method = RequestMethod.POST)
    public String cleanOrder(@CookieValue("BSESSIONID") String bsessionid, Model model, HttpServletRequest request){
        Order order = orderService.findByJsessionId(bsessionid);
        order.getOrderedProducts().clear();
        orderService.save(order);
        addDefaultModels(model, order);
        return "redirect:" + request.getHeader("referer");
    }

    @RequestMapping(value = "/order/delete", method = RequestMethod.GET)
    public String deleteOrderedProductFromOrder(@CookieValue("BSESSIONID") String bsessionid, Model model, HttpServletRequest request, @RequestParam(name = "id", required = true) Long productId){
        Order order = orderService.findByJsessionId(bsessionid);

        order.getOrderedProducts().remove(order.getOrderedProducts().stream().filter(orP -> orP.getId() == productId).findFirst().get());
        //todo
       orderService.save(order);
        addDefaultModels(model, order);
        return "redirect:" + request.getHeader("referer");
    }

    @RequestMapping(value = "/order/inc", method = RequestMethod.GET)
    public String incProductCount(@CookieValue("BSESSIONID") String bsessionid, Model model, HttpServletRequest request, @RequestParam(name = "id", required = true) Long orderedProductId){
        orderedProductService.updateCount(orderedProductId, Integer.parseInt(request.getParameter("count")));
        Order order = orderService.findByJsessionId(bsessionid);
        addDefaultModels(model, order);
        return "redirect:" + request.getHeader("referer");
    }


    @RequestMapping(value = "/add-order", method = RequestMethod.POST)
    public void addOrder(@CookieValue("BSESSIONID") String bsessionid, HttpServletRequest request, Model model,
                            @RequestParam(name = "id", required = false) Integer productId, HttpServletResponse response) throws IOException {
        Order order = clientService.checkClient(bsessionid, request, response);
        if (orderService.addNewProductToOrder(productId, order) != null){
            response.setStatus(888);
        }
        else{
            response.setStatus(500);
        }
    }

    @ResponseBody
    @RequestMapping(value="/get-order", method = RequestMethod.GET)
    public OrderCountDto getOrder(@CookieValue("BSESSIONID") String bsessionid, HttpServletRequest request, HttpServletResponse response){
        Order order = clientService.checkClient(bsessionid, request, response);
        return new OrderCountDto(Integer.toString(order.getOrderedProducts().size()));
    }

    public Model addDefaultModels(Model model, Order order){
        model.addAttribute("orderInfo", order.getOrderedProducts().size());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("order", order);
        model.addAttribute("total",orderService.getTotalOrderProductsSummaryWithDiscount(order));
        model.addAttribute("hotProduct", productService.getHotProduct());
        return model;
    }
}
