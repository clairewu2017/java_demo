package com.example.demo.mvc.service;


import com.example.demo.mvc.model.User;
import com.example.demo.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by chunmei on 8/9/2017.
 */
//@Service
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void CreateUser(User user) {
        userRepository.save(user);
    }

    @Cacheable("users")
    public User getUserByEmail(String email) throws InterruptedException {
        return userRepository.findByEmail(email);
    }

}
