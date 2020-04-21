package com.cyf.billmanger.repository;

import com.cyf.billmanger.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findAllByUsernameAndPassword(String username,String password);
}
