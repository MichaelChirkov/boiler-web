package com.chirkovm.dao;

import com.chirkovm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Michael Chirkov on 08.12.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
