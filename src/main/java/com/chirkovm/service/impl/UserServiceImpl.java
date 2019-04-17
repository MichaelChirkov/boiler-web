package com.chirkovm.service.impl;

import com.chirkovm.dao.UserRepository;
import com.chirkovm.model.User;
import com.chirkovm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Michael Chirkov on 15.11.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String registr(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null){

            return "redirect:/admin/registration?error";
        }
        else {
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            return "redirect:/admin?registr_success";
        }

    }
}
