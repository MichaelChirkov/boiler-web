package com.chirkovm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.chirkovm")
@EnableCaching
public class BoilerWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BoilerWebApplication.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(BoilerWebApplication.class, args);
    }
}
