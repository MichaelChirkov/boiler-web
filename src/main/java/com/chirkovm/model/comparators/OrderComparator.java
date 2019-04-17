package com.chirkovm.model.comparators;

import com.chirkovm.model.Order;

import java.util.Comparator;

/**
 * Created by Michael Chirkov on 17.03.2018.
 */
public class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return o1.getOrderTime().compareTo(o2.getOrderTime());
    }
}
