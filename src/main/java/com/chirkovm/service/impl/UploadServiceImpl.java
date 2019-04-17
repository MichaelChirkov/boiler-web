package com.chirkovm.service.impl;

import com.chirkovm.dao.ImgCountRepository;
import com.chirkovm.model.ImgCount;
import com.chirkovm.model.Pricelist;
import com.chirkovm.service.PricelistService;
import com.chirkovm.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Michael Chirkov on 31.01.2018.
 */
@Service
@Lazy
public class UploadServiceImpl implements UploadService {

    @Autowired
    private ImgCountRepository imgCountRepository;

    @Autowired
    Environment env;

    @Autowired
    private PricelistService pricelistService;

    private final String pathName = "C:\\upload\\";
    private final String imageFormat = ".jpg";

    @Override
    public String upload(MultipartFile file) {
        ImgCount imgCount = imgCountRepository.getOne(1L);
        imgCount.setValue(imgCount.getValue() + 1L);
        imgCount = imgCountRepository.save(imgCount);
        String fileName = imgCount.getValue() + imageFormat;
        if (!file.isEmpty() && file != null) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(pathName, fileName)));
                stream.write(bytes);
                stream.close();
                return imgCount.getValue().toString();
            } catch (Exception e) {
                return e.getMessage();
            }
        } else {
            return null;
        }
    }

    @Override
    public String uploadWithPath(MultipartFile file) {
        return pathName + upload(file);
    }

    @Override
    public String getImageUrl(MultipartFile file) {
        return env.getProperty("web.name") + "/image?id=" + imgCountRepository.getOne(1L).getValue();
    }

    @Override
    public void getImage(Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        ServletContext cntx = request.getServletContext();
        String filename = pathName + id + imageFormat;
        String mime = cntx.getMimeType(filename);
        if (mime == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        response.setContentType(mime);
        File file = new File(filename);
        response.setContentLength((int) file.length());

        FileInputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();

        // Copy the contents of the file to the output stream
        byte[] buf = new byte[2048];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();
    }

    @Override
    public void delete(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            File file = new File(pathName + fileName + imageFormat);
            if (file.delete()) {
                System.out.println(pathName + fileName + imageFormat + " файл удален");
            } else System.out.println(pathName + fileName + imageFormat + " не обнаружено");
        }
    }

    @Override
    public String uploadPdf(MultipartFile file) {
        ImgCount imgCount = imgCountRepository.getOne(1L);
        imgCount.setValue(imgCount.getValue() + 1L);
        imgCount = imgCountRepository.save(imgCount);
        String fileName = imgCount.getValue() + ".pdf";
        if (!file.isEmpty() && file != null) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(pathName, fileName)));
                stream.write(bytes);
                stream.close();
                return imgCount.getValue().toString();
            } catch (Exception e) {
                return e.getMessage();
            }
        } else {
            return null;
        }
    }

    @Override
    public void getPdf(Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        Pricelist pricelist = pricelistService.getOne(id);
        File file = new File(pathName + pricelist.getLink() + ".pdf");
      //  response.setHeader("Content-Disposition",
      //          "attachment;filename=downloadname.pdf");
      //  response.setHeader("content-type : application/pdf", "content-disposition:inline; filename = " + pricelist.getEngName() + ".pdf");
       // response.setContentType("text/plain");
        response.setContentType("application/pdf");
        response.setHeader("Content-Type", "application/force-download");
        response.setHeader("Content-Disposition", "inline; filename=\"" + pricelist.getEngName() + ".pdf" + "\";");
        response.setContentLength((int) file.length());
        FileInputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] buf = new byte[4096];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();
    }

    @Override
    public void deletePdf(String filename) {
        File file = new File(pathName + filename + ".pdf");
        if (file.delete()) {
            System.out.println(pathName + filename + ".pdf" + " файл удален");
        } else System.out.println(pathName + filename + ".pdf" + " не обнаружено");

    }
}
