package com.chirkovm.service.impl;

import com.chirkovm.dao.OrderedProductRepository;
import com.chirkovm.model.Order;
import com.chirkovm.model.OrderedProduct;
import com.chirkovm.service.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael Chirkov on 10.12.2017.
 */
@Service
public class OrderedProductServiceImpl implements OrderedProductService{

    @Autowired
    private OrderedProductRepository orderedProductRepository;

    @Override
    public OrderedProduct save(OrderedProduct orderedProduct) {
        return orderedProductRepository.save(orderedProduct);
    }

    @Override
    public void updateCount(Long orderedProductId, Integer count) {
        OrderedProduct orderedProduct = orderedProductRepository.findOne(orderedProductId);
        orderedProduct.setCount(count);
        orderedProductRepository.save(orderedProduct);
    }

    @Override
    public void deleteFromOrder(Order order, Long orderedProductId) {
        orderedProductRepository.delete(order.getOrderedProducts().stream().filter(orP -> orP.getId() == orderedProductId).findFirst().get().getId());
    }
}
