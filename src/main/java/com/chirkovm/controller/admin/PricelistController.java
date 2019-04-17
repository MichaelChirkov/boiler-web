package com.chirkovm.controller.admin;

import com.chirkovm.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Michael Chirkov on 17.03.2018.
 */
@Controller
@PreAuthorize("hasRole('ADMIN')")
public class PricelistController {

    @Autowired
    private PricelistService pricelistService;

    @RequestMapping(value = "/admin/pricelists", method = RequestMethod.GET)
    public String showPricelistsPage(Model model){
        model.addAttribute("pricelists", pricelistService.getAllPricelists());
        return "admin\\a-pricelists";
    }

    @RequestMapping(value = "/admin/pricelists/add", method = RequestMethod.POST)
    public String addSomePricelist(Model model, HttpServletRequest request, MultipartFile pdfFile){
        pricelistService.save(request, pdfFile);
        return "redirect:/admin/pricelists";
    }

    @RequestMapping(value = "/admin/pricelists/edit", method = RequestMethod.GET)
    public String showPricelistEditPage(Model model, @RequestParam(name = "id", required=true) Integer pricelistId){
        model.addAttribute("pricelist", pricelistService.getOne(pricelistId));
        return "admin\\a-pricelists-edit";
    }

    @RequestMapping(value = "/admin/pricelists/edit", method = RequestMethod.POST)
    public String editSomePricelist(Model model, HttpServletRequest request, MultipartFile pdfFile){
        pricelistService.edit(request, pdfFile);
        return "redirect:/admin/pricelists";
    }

    @RequestMapping(value = "/admin/pricelists/delete", method = RequestMethod.GET)
    public String deleteSomePricelist(Model model, @RequestParam(name = "id", required=true) Integer pricelistId){
        pricelistService.delete(pricelistId);
        return "redirect:/admin/pricelists";
    }
}
