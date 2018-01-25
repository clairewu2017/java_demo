package com.example.demo.mvc.service;


import com.example.demo.mvc.model.User;
import com.example.demo.mvc.repository.PermissionRepository;
import com.example.demo.mvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.data.domain.Pageable;
import java.util.Collection;
import java.util.List;

/**
 * Created by chunmei on 8/9/2017.
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @ModelAttribute("employeeList")
    public List<User> getAll()
    {
        return (List<User>) userRepository.findAll();
    }


    //示例：分页支持
    public Page<User> getAllByPage(Pageable pageable)
    {
        return userRepository.findAll(pageable);
    }

    public void delete(long id) {
        userRepository.delete(id);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    @Cacheable("users")
    public User getUserByEmail(String email) throws InterruptedException {

        Iterable<User> users = userRepository.findAll();
        for (User user:
            users ) {
            System.out.printf(user.getUserName());
        }
        return userRepository.findByEmail(email);
    }

    public Collection<? extends GrantedAuthority> getPermissions(long id) {
        List<String> permissionList = permissionRepository.findByUser(id);
        String[] permissionArray = permissionList.toArray(new String[0]);
        return AuthorityUtils.createAuthorityList(permissionArray);
    }

}
