package com.chirkovm.model.enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * Created by Michael Chirkov on 05.04.2018.
 */
public enum BaseUrlEnum {

    HOME("/"),
    HOWTOBUY("/how-to-buy"),
    DELIVERY("delivery"),
    GARUANTEES("/guarantees"),
    ABOUT("/about"),
    PRICELISTS("/pricelists"),
    CONTACTS("/contacts"),
    CHIMNEYS("/chimneys"),
    MODULLARS("/modular-boiler"),
    SPARPARTS("/spar-parts");

    private String url;

    BaseUrlEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
