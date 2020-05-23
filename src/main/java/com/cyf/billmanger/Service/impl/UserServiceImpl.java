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
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

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

    @Override
    public UserInfor getUser(String id) {
        UserInfor userInfor = userRepository.getUserInforById(id);
        return userInfor;
    }

    @Override
    public void saveUser(User user) {
        if(StringUtils.isEmpty(user.getId())){
            user.setId(UUID.randomUUID().toString());
        }else{
            User oldUser = userRepository.findById(user.getId()).get();
            if(StringUtils.isEmpty(user.getPassword())){
                user.setPassword(oldUser.getPassword());
            }
            if(StringUtils.isEmpty(user.getUsername())){
                user.setUsername(oldUser.getUsername());
            }
        }
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
