package com.chirkovm.controller;

import com.chirkovm.model.Client;
import com.chirkovm.model.Order;
import com.chirkovm.service.ClientService;
import com.chirkovm.service.EmailService;
import com.chirkovm.service.OrderService;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by Michael Chirkov on 21.01.2018.
 */
@Controller
public class ClientController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmailService emailService;


    @RequestMapping(value = "/confirm-order", method = RequestMethod.POST)
    public String confirmOrder(HttpServletResponse res, @CookieValue(value = "BSESSIONID", required = false) String bsessionid, HttpServletRequest request, Model model, HttpServletResponse response) throws MessagingException, UnsupportedEncodingException {
        Order order = clientService.checkClient(bsessionid, request, response);
        Client client = clientService.save(request);
        orderService.confirm(order, client);
        emailService.sendSimpleMessage(orderService.getOrderAsString(order), "Новый заказ № " +order.getId().toString());
        request.getSession().invalidate();
        request.getSession(true);
        model.addAttribute("order", clientService.checkClient(null, request, response));
        return "redirect:" + request.getHeader("referer") + "?success=true";
    }
}
