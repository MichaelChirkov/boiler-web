package com.chirkovm.controller.admin;

import com.chirkovm.model.User;
import com.chirkovm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Michael Chirkov on 08.12.2017.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping( value = "/admin/registration", method = RequestMethod.GET)
    public String showRegistrationPage(){
        return "admin\\registration";
    }

    @RequestMapping(value = "/admin/registration", method = RequestMethod.POST)
    public String registrationPost(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        User newUser = new User(username, password, name);
        //todo сделать проверку
       return userService.registr(newUser);
    }

}
