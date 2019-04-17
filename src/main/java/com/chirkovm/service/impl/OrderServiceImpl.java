package com.chirkovm.service.impl;

import com.chirkovm.dao.OrderRepository;
import com.chirkovm.model.Client;
import com.chirkovm.model.Order;
import com.chirkovm.model.OrderedProduct;
import com.chirkovm.service.OrderService;
import com.chirkovm.service.OrderedProductService;
import com.chirkovm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Michael Chirkov on 15.11.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderedProductService orderedProductService;

    @Autowired
    private ProductService productService;


    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findByJsessionId(String sessionId) {
        Order order = orderRepository.findBySessionId(sessionId);
        if (order == null){
            Order newOrder = new Order();
            newOrder.setSessionId(sessionId);
            return newOrder;
        }
        return order;
    }

    @Override
    public Long getTotalOrderProductsSummaryWithDiscount(Order order) {
        long summary = 0;
        for (OrderedProduct orderProduct :
                order.getOrderedProducts()) {
            summary += orderProduct.getCount() *
                    (orderProduct.getProduct().getPrice() - orderProduct.getProduct().getPrice() * orderProduct.getProduct().getDiscount());
        }
        return summary;
    }

    @Override
    public void confirm(Order order, Client client){
        order.setClient(client);
        order.setConfirmed(true);
        order.setViewed(false);
        order.setOrderTime(LocalDateTime.now());
        order.setPrice(getTotalOrderProductsSummaryWithDiscount(order));
        orderRepository.save(order);
    }

    @Override
    public Order addNewProductToOrder(Integer productId, Order order) {
        OrderedProduct orderedProduct = order.getOrderedProducts().stream().filter(orderedP -> orderedP.getProduct().getId() == productId).findFirst().orElse(null);
        if (orderedProduct == null) {
            order.getOrderedProducts().add(
                    orderedProductService.save(new OrderedProduct(productService.getById(productId), 1)));
        } else {
            orderedProduct.setCount(orderedProduct.getCount() + 1);
        }
        return save(order);
    }

    @Override
    public Integer getOrderedProductsTotalCount(Order order) {
        Integer count = 0;
        List<OrderedProduct> list = order.getOrderedProducts();
        for (OrderedProduct orderedProduct : list) {
            count += orderedProduct.getCount();
        }
        return count;
    }

    @Override
    public String getOrderAsString(Order order) {
        int i = 1;
        String orderAsString ="В " + order.getOrderTime().toString() + " был оформлен под номером " + order.getId().toString() + ".\n \n " + "Состав заказа:";
        for (OrderedProduct orderedProduct: order.getOrderedProducts()) {
            orderAsString +=  "\n" + i + ". " + orderedProduct.getProduct().getName() + " " + orderedProduct.getCount().toString() + " шт.";
        }
        orderAsString = orderAsString + "\n ----------------------------------------------------------------------------";
        orderAsString = orderAsString + "\n Общая сумма заказа: " + order.getPrice().toString() + " руб.";
        orderAsString = orderAsString + "\n Общее кол-во товаров: " + getOrderedProductsTotalCount(order).toString() + " шт.\n";
        orderAsString = orderAsString + "----------------------------------------------------------------------------";
        orderAsString = orderAsString + "\n Информация о клиенте:";
        orderAsString = orderAsString + "\n Имя Отчество: " + order.getClient().getName() + " " + order.getClient().getPatronymic();
        orderAsString = orderAsString + "\n Номер телефона: " + order.getClient().getPhoneNumber().toString();
        orderAsString = orderAsString + "\n Электронная почта: " +order.getClient().getMail();
        return orderAsString;
    }

    @Override
    public String getNewOrders() {
        List<Integer> list = orderRepository.findNewOrders();
        return list.isEmpty() ? null : list.toString();
    }

    public void setViewed(){
        List<Order> notViewedOrders = orderRepository.findConfirmedOrders().stream().filter(order -> order.getViewed() == false).collect(Collectors.toList());
        notViewedOrders.stream().forEach(order -> order.setViewed(true));
        notViewedOrders.forEach(order -> orderRepository.save(order));
    }

    @Override
    public List<Order> getConfirmedOrders() {
        setViewed();
        return orderRepository.findConfirmedOrders();
    }

    @Override
    public Order getById(Long orderId) {
        return orderRepository.findOne(orderId);
    }
}
