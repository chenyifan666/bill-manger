package com.cyf.billmanger.Service.impl;

import com.cyf.billmanger.Service.UserService;
import com.cyf.billmanger.dto.UserInfor;
import com.cyf.billmanger.entities.User;
import com.cyf.billmanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password){
        User user = userRepository.findAllByUsernameAndPassword(username,password);
        return user;
    }

    public List<UserInfor> getUsers(){
        return userRepository.findUserList();
    }

    @Override
    public List<UserInfor> getUsers(User user) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("username",ExampleMatcher.GenericPropertyMatchers.contains());
        Example example = Example.of(user,matcher);
        return userRepository.findAll(example);
    }
}
