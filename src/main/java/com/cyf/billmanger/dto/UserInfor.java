package com.cyf.billmanger.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfor {

    public UserInfor(String id, String username, String realName, Integer gender, Date birthday, Integer userType) {
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.gender = gender;
        this.birthday = birthday;
        this.userType = userType;
    }

    private String id;

    private String username;

    private String realName;

    private Integer gender;

    private Date birthday;

    private Integer userType;
}
