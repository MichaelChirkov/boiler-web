package com.chirkovm.service;

import com.chirkovm.model.Pricelist;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Michael Chirkov on 16.03.2018.
 */
public interface PricelistService {

    Pricelist save(HttpServletRequest request, MultipartFile pdfFile);

    Pricelist edit(HttpServletRequest request, MultipartFile pdfFile);

    void delete(Integer pricelistId);

    List<Pricelist> getAllPricelists();

    Pricelist getOne(Integer pricelistId);
}
