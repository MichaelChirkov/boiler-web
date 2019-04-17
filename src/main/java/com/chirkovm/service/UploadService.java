package com.chirkovm.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Michael Chirkov on 31.01.2018.
 */
public interface UploadService {

    String upload(MultipartFile file);

    void delete(String fileName);

    public void getImage(Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException;

    String uploadWithPath(MultipartFile file);

    String getImageUrl(MultipartFile file);

    String uploadPdf(MultipartFile file);

    public void getPdf(Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException;

    void deletePdf(String filename);
}
