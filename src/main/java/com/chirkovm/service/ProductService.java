package com.chirkovm.service;

import com.chirkovm.model.Category;
import com.chirkovm.model.Product;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Michael Chirkov on 15.11.2017.
 */
public interface ProductService {

    Product save(HttpServletRequest request, MultipartFile mainImg, MultipartFile schemaImg);

    Product save(Product product);

    List<Product> getAllProducts();

    List<Product> getAllProductsByCategory(Category category);

  //  List<Product> getAllProductsByCategoryId(Integer categoryId);

    Product getById(Integer productId);

    Product editProduct(HttpServletRequest request, MultipartFile mainImg, MultipartFile schemaImg);

    Product getHotProduct();

    void setHotProduct(String productId);

    List<Product> getTopProducts();

    void setTopProducts(HttpServletRequest request);

    void delete(Integer productId);

    Model getSparPart(Integer categoryId, Integer productId, Model model);
}
