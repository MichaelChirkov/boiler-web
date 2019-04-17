package com.chirkovm.dao;

import com.chirkovm.model.DeliveryMethod;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Michael Chirkov on 14.11.2017.
 */
public interface DeliveryMethodRepository extends JpaRepository<DeliveryMethod, Integer> {
}
