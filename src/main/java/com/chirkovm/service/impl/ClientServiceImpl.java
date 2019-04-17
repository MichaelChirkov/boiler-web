package com.chirkovm.service.impl;

import com.chirkovm.dao.ClientRepository;
import com.chirkovm.model.Client;
import com.chirkovm.model.Order;
import com.chirkovm.service.ClientService;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import com.chirkovm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Michael Chirkov on 14.01.2018.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderService orderService;

    @Override
    public Client save(HttpServletRequest req) {
        if (req.getParameter("phone").isEmpty()) {
            throw new IllegalArgumentException("Phone number must not be null.");
        }
        else {
            Client client = clientRepository.findByPhoneNumber(Long.parseLong(req.getParameter("phone")));
            if (client != null) {
                return client;
            }
            else {
               return clientRepository.save(new Client(req.getParameter("name"),
                        req.getParameter("patronymic"),
                        req.getParameter("email"),
                        req.getParameter("phone")));
            }
        }
    }

    @Override
    public Order checkClient(String bsessionid, HttpServletRequest request, HttpServletResponse response) {
        HttpSession sess = request.getSession(true);
        if (bsessionid==null) {
            Cookie cookie = new Cookie("BSESSIONID", sess.getId());
            cookie.setMaxAge(5000);
            response.reset();
            response.addCookie(cookie);
        }
        return orderService.findByJsessionId(bsessionid);
    }
}
