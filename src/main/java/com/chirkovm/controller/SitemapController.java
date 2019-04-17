package com.chirkovm.controller;

import com.chirkovm.model.other.XmlUrl;
import com.chirkovm.model.other.XmlUrlSet;
import com.chirkovm.service.SitemapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by Michael Chirkov on 05.04.2018.
 */
@Controller
public class SitemapController {

        @Autowired
        private SitemapService sitemapService;

        @RequestMapping(value = "/sitemap.xml", method = RequestMethod.GET)
        @ResponseBody
        public XmlUrlSet main() {
            XmlUrlSet xmlUrlSet = new XmlUrlSet();
            sitemapService.initialize(xmlUrlSet);
            return xmlUrlSet;
        }

    @RequestMapping(value = "/robots.txt", method = RequestMethod.GET)
    @ResponseBody
    public String getRobots(HttpServletRequest request) {
        return "User – agent: *\n" +
                "Disallow: /admin\n" +
                "Sitemap: http://rossen-kazan.ru/sitemap.xml";
    }
}

