package com.cyf.billmanger.repository;

import com.cyf.billmanger.dto.UserInfor;
import com.cyf.billmanger.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findAllByUsernameAndPassword(String username,String password);

    @Query(value = "select new com.cyf.billmanger.dto.UserInfor(u.id, u.username, u.realName, u.gender, u.birthday,u.userType) from User as u")
    List<UserInfor> findUserList();

    @Query(value = "select new com.cyf.billmanger.dto.UserInfor(u.id, u.username, u.realName, u.gender, u.birthday,u.userType) from User as u where id = :id ")
    UserInfor getUserInforById(@Param("id") String id);
}
