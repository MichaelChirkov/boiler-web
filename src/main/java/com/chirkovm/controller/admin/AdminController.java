package com.chirkovm.controller.admin;

import com.chirkovm.dao.ImgCountRepository;
import com.chirkovm.dao.ProductRepository;
import com.chirkovm.dao.PropertyRepository;
import com.chirkovm.model.*;
import com.chirkovm.model.comparators.OrderComparator;
import com.chirkovm.service.*;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Michael Chirkov on 16.11.2017.
 */
@Controller
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private PropertyNameService propertyNameService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderedProductService orderedProductService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UploadService uploadService;

    //todo сделать подгрузку из ресурсов
    //private final String pathName = "C:\\Users\\Michael\\Desktop\\rossen-web\\src\\main\\resources\\static\\images\\store";


    @RequestMapping(value = "/admin/property-names", method = RequestMethod.GET)
    public String showAdminPropertyNamesPage(Model model) {
        model.addAttribute("propertyNames", propertyNameService.getAllPropertyNames());
        return "admin\\apropertyNames";
    }

    @RequestMapping(value = "/admin/property-names/add", method = RequestMethod.POST)
    public String addNewProperty(Model model, HttpServletRequest request) {
        propertyNameService.save(new PropertyName(request.getParameter("name"), propertyNameService.checkBooleanType(request.getParameter("isSize"))));
        model.addAttribute("propertyNames", propertyNameService.getAllPropertyNames());
        return "redirect:/admin/property-names";
    }

    @RequestMapping(value = "/admin/property-names/delete", method = RequestMethod.GET)
    public String deleteSomePropertyName(Model model, @RequestParam(name = "id", required=true) Integer propertyNameId){
        propertyNameService.deletePropertyName(propertyNameId);
        return "redirect:/admin/property-names";
    }

    @RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
    public String showAdminCategoriesPage(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("propertyNames", propertyNameService.getAllPropertyNames());
        return "admin\\acategories";
    }

    @RequestMapping(value = "/admin/categories/add", method = RequestMethod.POST)
    public String addNewCategory(Model model, HttpServletRequest request, MultipartFile file, MultipartFile bannerImg) {
        Category category = categoryService.save(request, file, bannerImg);
        return "redirect:/admin/categories";
    }

    @RequestMapping(value = "/admin/categories/delete", method = RequestMethod.GET)
    public String deleteSomeCategory(Model model, @RequestParam(name = "id", required=true) Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return "redirect:/admin/categories";

    }

    @RequestMapping(value = "/admin/categories/edit", method = RequestMethod.GET)
    public String editSomeCategory(Model model, @RequestParam(name = "id", required=true) Integer categoryId){
        model.addAttribute(categoryService.getById(categoryId));
        return "admin\\acategory-edit";

    }

    @RequestMapping(value = "/admin/categories/edit", method = RequestMethod.POST)
    public String editCategory(Model model, HttpServletRequest request, MultipartFile imgUrl, MultipartFile bannerImg) {
        categoryService.editCategory(request, imgUrl, bannerImg);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
    public String showAdminProductPage(Model model,@RequestParam(name = "category", required=false) Integer categoryId, HttpServletRequest request) {
        if (categoryId != null) {
            model.addAttribute("propertyNames", categoryService.getAllPropertyNamesByCategory
                    (categoryId));
            model.addAttribute("category", categoryService.getById(categoryId));
        }
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin\\aproducts";
    }

    @RequestMapping(value = "/admin/products/add", method = RequestMethod.POST)
    public String addNewProduct(Model model, HttpServletRequest request, MultipartFile mainImg, MultipartFile schemaImg) {
     Product product = productService.save(request, mainImg, schemaImg);
        if (request.getParameter("category") != null) {
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("propertyNames", categoryService.getAllPropertyNamesByCategory
                    (Integer.parseInt(request.getParameter("category"))));
        }
        model.addAttribute("products", productService.getAllProducts());
        return "admin\\aproducts";
    }


    @RequestMapping(value = "/admin/product/edit", method = RequestMethod.GET)
    public String showAdminEditProductPage(Model model, @RequestParam(name = "id", required=true) Integer productId){
        model.addAttribute("product", productService.getById(productId));
        return "admin\\aproduct-edit";

    }

    @RequestMapping(value = "/admin/product/delete", method = RequestMethod.GET)
    public String deleteSomeProduct(Model model, @RequestParam(name = "id", required=true) Integer productId){
        productService.delete(productId);
        return "redirect:/admin/products";

    }

    @RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
    public String editProduct(Model model, HttpServletRequest request, MultipartFile mainImg, MultipartFile schemaImg) {
        productService.editProduct(request, mainImg, schemaImg);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/admin/hot-product", method = RequestMethod.POST)
    public String editHotProduct(Model model, HttpServletRequest request){
            productService.setHotProduct(request.getParameter("newHotProduct"));
        return "redirect:/admin/hot-product";
    }

    @RequestMapping(value = "/admin/hot-product", method = RequestMethod.GET)
    public String showHotProductPage(Model model, HttpServletRequest request){
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("hotProduct", productService.getHotProduct());
        return "admin\\a-hot-product";
    }

    @RequestMapping(value="/admin/top-products", method = RequestMethod.GET)
    public String showTopProductsPage(Model model){
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("topProducts", productService.getTopProducts());
        return "admin\\atop-products";
    }

    @RequestMapping(value="/admin/top-products", method = RequestMethod.POST)
    public String setTopProducts(HttpServletRequest request){
        productService.setTopProducts(request);
        return "redirect:/admin/top-products";
    }

    @RequestMapping(value="/admin/upload" , method = RequestMethod.POST)
    public String uploadImage(Model model, HttpServletRequest request, MultipartFile file){
        model.addAttribute("imgUrl", uploadService.getImageUrl(file));
        return "admin\\a-upload-pic";
    }

    @RequestMapping(value = "/admin/upload", method = RequestMethod.GET)
    public String showUploadPage(Model model){
        return "admin\\a-upload-pic";
    }

    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
    public String showOrdersPage(Model model){
        model.addAttribute("newOrders", orderService.getNewOrders());
        model.addAttribute("orders", orderService.getConfirmedOrders().stream().sorted(new OrderComparator()).collect(Collectors.toList()));
        return "admin\\a-orders";
    }

    @RequestMapping(value = "/admin/orders/info", method = RequestMethod.GET)
    public String showOrderInfoPage(Model model, @RequestParam(name = "id", required=true) Long orderId){
        model.addAttribute("order", orderService.getById(orderId));
        return "admin\\a-order-info";
    }

}
