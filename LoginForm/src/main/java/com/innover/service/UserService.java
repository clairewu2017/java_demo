package com.innover.service;

import com.innover.data.User;
import com.innover.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * Created by chunmei on 8/9/2017.
 */
//@Service
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ROLE_USER')")
    public void CreateUser(User user) {
        userRepository.save(user);
    }

    @Cacheable("users")
    public User getUserByEmail(String email) throws InterruptedException {
        Thread.sleep(40000);
        return userRepository.findByEmail(email);
    }

}
