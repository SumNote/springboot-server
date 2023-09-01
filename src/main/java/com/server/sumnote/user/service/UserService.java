package com.server.sumnote.user.service;

import com.server.sumnote.user.entity.User;
import com.server.sumnote.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User checkAndCreateUser(String email, String name) {

        if(userRepository.findByEmail(email) == null) {
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            userRepository.save(user);
            return user;
        }
        else return userRepository.findByEmail(email);
    }

    @Transactional
    public void deleteUser(String email) {
        userRepository.deleteUserByEmail(email);
    }

}
