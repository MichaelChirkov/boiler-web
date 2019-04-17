package com.chirkovm.service.impl;

import com.chirkovm.dao.PropertyNameRepository;
import com.chirkovm.model.PropertyName;
import com.chirkovm.service.PropertyNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Michael Chirkov on 16.11.2017.
 */
@Service
public class PropertyNameServiceImpl implements PropertyNameService {

    @Autowired
    private PropertyNameRepository propertyNameRepository;

    @Override
    public void save(PropertyName propertyName) {
        propertyNameRepository.save(propertyName);
    }

    @Override
    public List<PropertyName> getAllPropertyNames() {
        return propertyNameRepository.findAll();
    }

    @Override
    public PropertyName getById(Integer id) {
        return propertyNameRepository.findOne(id);
    }

    @Override
    public Boolean checkBooleanType(String flag) {
        if (flag != null) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    @Override
    public void deletePropertyName(Integer propertyNameId) {
        propertyNameRepository.delete(propertyNameId);
    }
}
