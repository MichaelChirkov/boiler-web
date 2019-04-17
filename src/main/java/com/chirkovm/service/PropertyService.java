package com.chirkovm.service;

import com.chirkovm.model.Property;

import java.util.List;
import java.util.Set;

/**
 * Created by Michael Chirkov on 15.11.2017.
 */
public interface PropertyService {

    void save(Property property);

    List<Property> getAllProperties();


}
