package com.chirkovm.service.impl;

import com.chirkovm.model.Category;
import com.chirkovm.model.Product;
import com.chirkovm.model.enums.BaseUrlEnum;
import com.chirkovm.model.other.XmlUrl;
import com.chirkovm.model.other.XmlUrlSet;
import com.chirkovm.service.CategoryService;
import com.chirkovm.service.ProductService;
import com.chirkovm.service.SitemapService;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by Michael Chirkov on 05.04.2018.
 */
@Service
public class SitemapServiceImpl implements SitemapService {

    @Autowired
    Environment env;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Override
    public void initialize(XmlUrlSet xmlUrlSet) {

        //for static pages
        for (BaseUrlEnum element: BaseUrlEnum.values()) {
            create(xmlUrlSet, element.getUrl(), XmlUrl.Priority.MEDIUM);
        }
        //add all product-pages
        List<Product> products = productService.getAllProducts();
        for (Product pr : products){
            create(xmlUrlSet, "/category/" + pr.getCategory().getId() + "/product/" + pr.getId(), XmlUrl.Priority.HIGH);
        }
        //add all category-pages
        List<Category> categories = categoryService.getAllCategories();
        for (Category category: categories){
            create(xmlUrlSet, "/category/" + category.getId(), XmlUrl.Priority.HIGH);
        }

    }

    public void create(XmlUrlSet xmlUrlSet, String link, XmlUrl.Priority priority) {
        xmlUrlSet.addUrl(new XmlUrl(env.getProperty("web.name") + link, priority));
    }
}
