package com.chirkovm.service.impl;


import com.chirkovm.dao.PropertyRepository;
import com.chirkovm.model.Product;
import com.chirkovm.model.Property;
import com.chirkovm.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Michael Chirkov on 15.11.2017.
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public void save(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

}
