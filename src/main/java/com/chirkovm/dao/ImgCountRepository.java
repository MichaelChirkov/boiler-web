package com.chirkovm.dao;

import com.chirkovm.model.ImgCount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Michael Chirkov on 31.01.2018.
 */
public interface ImgCountRepository extends JpaRepository<ImgCount, Long> {
}
