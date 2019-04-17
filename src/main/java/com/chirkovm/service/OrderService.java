package com.chirkovm.service;

import com.chirkovm.model.Client;
import com.chirkovm.model.Order;

import java.util.List;


/**
 * Created by Michael Chirkov on 15.11.2017.
 */
public interface OrderService {

    Order save(Order order);

   Order findByJsessionId(String sessionId);

   Order addNewProductToOrder(Integer productId, Order order);

   Long getTotalOrderProductsSummaryWithDiscount(Order order);

   void confirm(Order order, Client client);

   Integer getOrderedProductsTotalCount(Order order);

   String getOrderAsString(Order order);

   String getNewOrders();

   List<Order> getConfirmedOrders();

   Order getById(Long orderId);
}
