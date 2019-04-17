package com.chirkovm.dao;

import com.chirkovm.model.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Michael Chirkov on 16.03.2018.
 */
public interface PricelistRepository extends JpaRepository<Pricelist, Integer> {
}
