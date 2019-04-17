package com.chirkovm.service;

import com.chirkovm.model.Order;
import com.chirkovm.model.OrderedProduct;

/**
 * Created by Michael Chirkov on 10.12.2017.
 */
public interface OrderedProductService {

    OrderedProduct save(OrderedProduct orderedProduct);

    void updateCount(Long orderedProductId, Integer count);

    void deleteFromOrder(Order order, Long orderedProductId);
}
