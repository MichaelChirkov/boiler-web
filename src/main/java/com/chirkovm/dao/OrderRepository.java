package com.chirkovm.dao;

import com.chirkovm.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findBySessionId(String sessionId);

    @Query("select order.id from Order order where order.viewed = false and order.confirmed = true")
    List<Integer> findNewOrders();

    @Query("select order from Order order where order.confirmed = true")
    List<Order> findConfirmedOrders();
}
