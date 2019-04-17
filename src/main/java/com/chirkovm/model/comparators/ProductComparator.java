package com.chirkovm.model.comparators;

import com.chirkovm.model.Product;

import java.util.Comparator;

/**
 * Created by Michael Chirkov on 05.03.2018.
 */
public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product prod1, Product prod2) {
        return prod1.getPrice().compareTo(prod2.getPrice());
    }
}
