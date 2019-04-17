package com.chirkovm.model.comparators;

import com.chirkovm.model.Property;

import java.util.Comparator;

/**
 * Created by Michael Chirkov on 26.02.2018.
 */
public class PropertyComparator implements Comparator<Property> {

    public int compare(Property p1, Property p2){
        return p1.getPropertyName().getName().compareTo(p2.getPropertyName().getName());
    }
}
