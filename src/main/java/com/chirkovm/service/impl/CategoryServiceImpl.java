package com.chirkovm.service.impl;

import com.chirkovm.dao.CategoryRepository;
import com.chirkovm.model.Category;
import com.chirkovm.model.PropertyName;
import com.chirkovm.model.comparators.PropertyNameComparator;
import com.chirkovm.service.CategoryService;
import com.chirkovm.service.PropertyNameService;
import com.chirkovm.service.UploadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Michael Chirkov on 15.11.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PropertyNameService propertyNameService;

    @Autowired
    private UploadService uploadService;



    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<PropertyName> getAllPropertyNamesByCategory(Integer categoryId) {

        return categoryRepository.findOne(categoryId).getPropertyNames();
                //.stream().sorted(new PropertyNameComparator()).collect(Collectors.toList());
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category save(HttpServletRequest request, MultipartFile image, MultipartFile bannerImg) {
        List<PropertyName> propertyNames = new ArrayList<>();
        String[] propertyNamesString = request.getParameterValues("selectedPropertyNames");
        if (propertyNamesString != null) {
            for (int i = 0; i < propertyNamesString.length; i++) {
                propertyNames.add(propertyNameService.getById(Integer.parseInt(propertyNamesString[i])));
            }
        }
        Category category = categoryRepository.save(new Category(
                request.getParameter("name"),
                propertyNames,
                request.getParameter("shortDescription")
        ));

        category.setImgUrl(uploadService.upload(image));
        category.setBannerImg(uploadService.upload(bannerImg));
        return save(category);
    }

    @Transactional
    @Override
    public void deleteCategory(Integer categoryId) {
        categoryRepository.delete(categoryId);
    }

    @Override
    public void editCategory(HttpServletRequest request, MultipartFile imgUrl, MultipartFile bannerImg) {
        Category category = categoryRepository.getOne(Integer.parseInt(request.getParameter("categoryId")));
        if (!request.getParameter("name").isEmpty()){
            category.setName(request.getParameter("name"));
        }
        if (!request.getParameter("shortDescription").isEmpty()){
            category.setShortDescription(request.getParameter("shortDescription"));
        }
        if (!imgUrl.isEmpty()){
            uploadService.delete(category.getImgUrl());
            category.setImgUrl(uploadService.upload(imgUrl));
        }
        if (!bannerImg.isEmpty()){
            uploadService.delete(category.getBannerImg());
            category.setBannerImg(uploadService.upload(bannerImg));
        }
        categoryRepository.save(category);
    }
}
