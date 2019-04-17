package com.chirkovm.dao;

import com.chirkovm.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
