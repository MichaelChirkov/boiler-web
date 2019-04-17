package com.chirkovm.service;

import com.chirkovm.model.Category;
import com.chirkovm.model.PropertyName;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * Created by Michael Chirkov on 15.11.2017.
 */
public interface CategoryService {


    Category save(HttpServletRequest request, MultipartFile file, MultipartFile bannerImg);

    Category save(Category category);

    List<Category> getAllCategories();

    List<PropertyName> getAllPropertyNamesByCategory(Integer categoryId);

    Category getById(Integer id);

    void deleteCategory(Integer categoryId);

    void editCategory(HttpServletRequest request, MultipartFile imgUrl, MultipartFile bannerImg);
}
