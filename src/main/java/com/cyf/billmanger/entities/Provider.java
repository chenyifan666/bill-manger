package com.cyf.billmanger.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Provider {
    @Id
    private String id;

    @Column(name = "provider_code")
    private String providerCode;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "people")
    private String people;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "fax")
    private String fax;

    @Column(name = "describe")
    private String describe;

    @Column(name = "create_date")
    private Date createDate;
}
