package com.chirkovm.service.impl;

import com.chirkovm.dao.PricelistRepository;
import com.chirkovm.model.Pricelist;
import com.chirkovm.service.PricelistService;
import com.chirkovm.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by Michael Chirkov on 16.03.2018.
 */
@Service
public class PricelistServiceImpl implements PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Autowired
    private UploadService uploadService;

    @Override
    public Pricelist save(HttpServletRequest request, MultipartFile pdfFile) {
        Pricelist pricelist = new Pricelist();
        pricelist.setName(request.getParameter("name"));
        pricelist.setEngName(request.getParameter("engName"));
        pricelist.setLink(uploadService.uploadPdf(pdfFile));
        return pricelistRepository.save(pricelist);
    }

    @Override
    public Pricelist edit(HttpServletRequest request, MultipartFile pdfFile) {
        Pricelist pricelist = pricelistRepository.findOne(Integer.parseInt(request.getParameter("pricelistId")));
        pricelist.setName(request.getParameter("name"));
        pricelist.setEngName(request.getParameter("engName"));
        if (!pdfFile.isEmpty()){
            uploadService.deletePdf(pricelist.getLink());
            pricelist.setLink(uploadService.uploadPdf(pdfFile));
        }
        return pricelistRepository.save(pricelist);
    }

    @Override
    public void delete(Integer pricelistId) {
        pricelistRepository.delete(pricelistId);
    }

    @Override
    public List<Pricelist> getAllPricelists() {
        return pricelistRepository.findAll();
    }

    @Override
    public Pricelist getOne(Integer pricelistId) {
        return pricelistRepository.findOne(pricelistId);
    }
}
