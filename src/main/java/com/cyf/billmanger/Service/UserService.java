package com.cyf.billmanger.Service;

import com.cyf.billmanger.dto.UserInfor;
import com.cyf.billmanger.entities.User;
import com.cyf.billmanger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User login(String username,String password);

    List<UserInfor> getUsers();

    List<UserInfor> getUsers(User user);
}
