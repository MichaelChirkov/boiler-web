package com.chirkovm.service;

import com.chirkovm.model.PropertyName;

import java.util.List;

/**
 * Created by Michael Chirkov on 16.11.2017.
 */
public interface PropertyNameService {

    void save (PropertyName propertyName);

    List<PropertyName> getAllPropertyNames();

    PropertyName getById(Integer id);

    Boolean checkBooleanType(String type);

    void deletePropertyName(Integer propertyNameId);
}
