package com.chirkovm.dao;

import com.chirkovm.model.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Michael Chirkov on 10.12.2017.
 */
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {
}
