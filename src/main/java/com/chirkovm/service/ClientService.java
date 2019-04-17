package com.chirkovm.service;

import com.chirkovm.model.Client;
import com.chirkovm.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;

/**
 * Created by Michael Chirkov on 14.01.2018.
 */
public interface ClientService {

    Client save(HttpServletRequest httpServletRequest);

    Order checkClient(String bsessionid , HttpServletRequest request, HttpServletResponse response);

}
