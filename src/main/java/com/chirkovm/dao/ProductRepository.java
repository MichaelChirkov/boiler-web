package com.chirkovm.dao;

import com.chirkovm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(Integer categoryId);

    @Query("select product from Product  product where product.isDeleted = false ")
    List<Product> findProducts();

}
