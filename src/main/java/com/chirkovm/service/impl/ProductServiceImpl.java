package com.chirkovm.service.impl;

import com.chirkovm.dao.ProductRepository;
import com.chirkovm.model.*;
import com.chirkovm.model.comparators.ProductComparator;
import com.chirkovm.model.comparators.PropertyComparator;
import com.chirkovm.service.CategoryService;
import com.chirkovm.service.ProductService;
import com.chirkovm.service.PropertyNameService;
import com.chirkovm.service.UploadService;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Michael Chirkov on 15.11.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PropertyNameService propertyNameService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UploadService uploadService;


    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findProducts();
    }

    @Autowired
    private Environment environment;

    @Override
    public List<Product> getAllProductsByCategory(Category category) {
        return productRepository.findProducts().stream().filter(pr -> pr.getCategory() == category).sorted(new ProductComparator()).collect(Collectors.toList());
    }

    @Override
    public Product getById(Integer productId) {
        return productRepository.findOne(productId);
    }

    @Override
    public Product editProduct(HttpServletRequest request, MultipartFile mainImg, MultipartFile schemaImg) {

        Product product = productService.getById(Integer.parseInt(request.getParameter("productId")));
        String[] sparPartsString = request.getParameterValues("selectedSparParts");
        //todo обернуть в метод
        if (request.getParameterValues("selectedSparParts") != null) {
            product.getSparParts().clear();
            for (int i = 0; i < sparPartsString.length; i++) {
                product.getSparParts().add(productRepository.findOne(Integer.parseInt(sparPartsString[i])));
            }
        }
        product.getProperties().stream().forEach(pr -> pr.setValue(request.getParameter(Long.toString(pr.getId()))));
        String price = StringUtils.remove(request.getParameter("price"), (char) 160);

        //todo v metod
        product.setName(checkNull("name", request));
        product.setPrice(Integer.parseInt(price != null ? price : "0"));
        product.setDiscount((Double.parseDouble(request.getParameter("discount") != null ? request.getParameter("discount") : "0"))/100);
        product.setDescription(checkNull("description", request));
        if (!mainImg.isEmpty()) {
            uploadService.delete(product.getMainImg());
            product.setMainImg(uploadService.upload(mainImg));
        }
        if (!schemaImg.isEmpty()) {
            uploadService.delete(product.getSchemaImg());
            product.setSchemaImg(uploadService.upload(schemaImg));
        }
        return productService.save(product);
    }

    @Override
    public Product getHotProduct() {
        String hotProductAsString = "";
        try {
            PropertiesConfiguration config = new PropertiesConfiguration("variables.properties");
            if (config.getProperty("hot.product") != null) {
                hotProductAsString = config.getProperty("hot.product").toString();
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        if (hotProductAsString != null) {
            return productRepository.findOne(Integer.parseInt(hotProductAsString));
        } else {
            return null;
        }

    }

    @Override
    public void setHotProduct(String productId) {
        PropertiesConfiguration config = null;
        try {
            config = new PropertiesConfiguration("variables.properties");
            config.setProperty("hot.product", productId);
            config.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product save(HttpServletRequest request, MultipartFile mainImg, MultipartFile schemaImg) {
        String price = request.getParameter("price");
        if (propertyNameService.checkBooleanType(request.getParameter("isSparPart"))) {
            Product product = new Product();

            product.setName(checkNull("name", request));
            product.setPrice(Integer.parseInt(price != null ? price : "0"));
            product.setDiscount((Double.parseDouble(checkNull("discount", request)))/100);
            product.setDescription(checkNull("description", request));
            product.setCategory(categoryService.getById(Integer.parseInt(request.getParameter("category"))));
            product.setIsSparPart(true);
            product.setIsDeleted(false);
            product.setSchemaImg(null);
            product.setMainImg(uploadService.upload(mainImg));
            product.setSparParts(null);
            product.setProperties(null);
            return productService.save(product);
        } else {

            List<PropertyName> propertyNames = categoryService.getAllPropertyNamesByCategory
                    (Integer.parseInt(request.getParameter("category")));
            Set<Product> sparParts = new HashSet<>();
            List<Property> properties = new ArrayList<>();
            String[] sparPartsString = request.getParameterValues("selectedSparParts");

            if (sparPartsString != null) {
                for (int i = 0; i < sparPartsString.length; i++) {
                    sparParts.add(productService.getById(Integer.parseInt(sparPartsString[i])));
                }
            }
            propertyNames.stream().forEach(prN -> properties.add(new Property(prN, request.getParameter(prN.getName()))));

            Product product = new Product();
            product.setName(checkNull("name", request));
            product.setPrice(Integer.parseInt(price != null ? price : "0"));
            product.setDiscount(Double.parseDouble(checkNull("discount", request)));
            product.setDescription(checkNull("description", request));
            product.setCategory(categoryService.getById(Integer.parseInt(request.getParameter("category"))));
            product.setIsSparPart(false);
            product.setIsDeleted(false);
            product.setSchemaImg(uploadService.upload(schemaImg));
            product.setMainImg(uploadService.upload(mainImg));
            product.setSparParts(sparParts);
            product.setProperties(properties);
            return productService.save(product);

        }
   /*     return productService.save(new Product(checkNull("name", request), Integer.parseInt(checkNull("price", request)),
                Double.parseDouble(checkNull("discount", request)), checkNull("description", request),
                categoryService.getById(Integer.parseInt(request.getParameter("category"))),
                sparParts,
                properties, propertyNameService.checkBooleanType(request.getParameter("isSparPart")))); */
    }

    @Override
    public void delete(Integer productId) {

        Product product = productRepository.findOne(productId);
        product.setIsDeleted(true);
        productRepository.save(product);
    }

    @Override
    public Model getSparPart(Integer categoryId, Integer productId, Model m) {
        if (categoryId == null) {
            m.addAttribute("categories", categoryService.getAllCategories());
            return m;
        } else {
            if (productId != null) {
                m.addAttribute("sparParts", productService.getById(productId).getSparParts());
                return m;
            } else {
                m.addAttribute("products", productService.getAllProductsByCategory(categoryService.getById(categoryId)));
                m.addAttribute("category", categoryService.getById(categoryId));
                return m;
            }
        }
    }

    public String checkNull(String parameterName, HttpServletRequest request) {
        if (request.getParameter(parameterName) == null) {
            return "";
        } else {
            return request.getParameter(parameterName);
        }
    }

    @Override
    public List<Product> getTopProducts() {
        List<Product> topProducts = new ArrayList<>();
        List<String> topProductsAsStringList = new ArrayList<>();

        try {
            PropertiesConfiguration config = new PropertiesConfiguration("variables.properties");
            if (config.getProperty("top.products") != null) {

                if (config.getProperty("top.products").getClass() == String.class) {
                    topProductsAsStringList.add((String) config.getProperty("top.products"));
                } else {
                    topProductsAsStringList = (ArrayList<String>) config.getProperty("top.products");
                }

                //       topProductsAsStringList = list.stream().map(object -> Objects.toString(object, null)).collect(Collectors.toList());
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        if (!topProductsAsStringList.isEmpty() && !topProductsAsStringList.get(0).equals("")) {
            for (String product : topProductsAsStringList) {
                topProducts.add(productRepository.findOne(Integer.parseInt(product)));
            }
        }
        return topProducts;
    }

    @Override
    public void setTopProducts(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        if (request.getParameterValues("selectedProducts") != null) {
            String[] topProductString = request.getParameterValues("selectedProducts");

            for (int i = 0; i < topProductString.length; i++) {
                if (i + 1 != topProductString.length) {
                    sb.append(topProductString[i]).append(",");
                } else {
                    sb.append(topProductString[i]);
                }
            }
        }
        PropertiesConfiguration config = null;
            try {
                config = new PropertiesConfiguration("variables.properties");
                config.setProperty("top.products", sb.toString());
                config.save();
                config.refresh();
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }


    }


    // @Override
    // public List<Product> getAllProductsByCategoryId(Integer categoryId) {
    //     return productRepository.findByCategory(categoryId);
    // }
}
