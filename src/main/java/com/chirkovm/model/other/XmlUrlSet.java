package com.chirkovm.model.other;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Michael Chirkov on 05.04.2018.
 */
@XmlAccessorType(value = XmlAccessType.NONE)
@XmlRootElement(name = "urlset", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9")
public class XmlUrlSet {

    @XmlElements({@XmlElement(name = "url", type = XmlUrl.class)})
    private Collection<XmlUrl> xmlUrls = new ArrayList<XmlUrl>();

    public void addUrl(XmlUrl xmlUrl) {
        xmlUrls.add(xmlUrl);
    }

    public Collection<XmlUrl> getXmlUrls() {
        return xmlUrls;
    }
}