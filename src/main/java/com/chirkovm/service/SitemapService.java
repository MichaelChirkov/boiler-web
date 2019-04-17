package com.chirkovm.service;

import com.chirkovm.model.other.XmlUrl;
import com.chirkovm.model.other.XmlUrlSet;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;

/**
 * Created by Michael Chirkov on 05.04.2018.
 */
public interface SitemapService {

    public void initialize(XmlUrlSet xmlUrlSet);

}
