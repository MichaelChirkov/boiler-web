package com.chirkovm.dao;

import com.chirkovm.model.PropertyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Michael Chirkov on 16.11.2017.
 */
@Repository
public interface PropertyNameRepository extends JpaRepository<PropertyName, Integer> {
}
