package com.cyf.billmanger.Service;

import com.cyf.billmanger.entities.User;
import com.cyf.billmanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String username,String password){
        User user = userRepository.findAllByUsernameAndPassword(username,password);
        return user;
    }
}
