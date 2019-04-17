package com.chirkovm.model.comparators;

import com.chirkovm.model.PropertyName;

import java.util.Comparator;

/**
 * Created by Michael Chirkov on 19.11.2017.
 */
public class PropertyNameComparator implements Comparator<PropertyName> {

  /*  public int compare(PropertyName p1, PropertyName p2){
        return p1.getId()-p2.getId();
    }
*/
  public int compare(PropertyName p1, PropertyName p2){
      return p1.getName().compareTo(p2.getName());
  }


}
