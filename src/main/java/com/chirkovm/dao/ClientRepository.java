package com.chirkovm.dao;

import com.chirkovm.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Michael Chirkov on 14.01.2018.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByPhoneNumber(Long phoneNumber);
}
