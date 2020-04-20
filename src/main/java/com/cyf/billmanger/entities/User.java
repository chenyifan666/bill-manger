package com.cyf.billmanger.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "password")
    private String password;

    /*
        1.女
        2.男
     */
    @Column(name = "gender")
    private Integer gender;

    @Column(name = "birthday")
    private Date birthday;

    /*
        1.管理员
        2.经理
        3.普通用户
     */
    @Column(name = "user_type")
    private Integer userType;
}
