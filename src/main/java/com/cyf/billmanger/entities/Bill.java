package com.cyf.billmanger.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "bill")
@Data
public class Bill {
    @Id
    private String bid;
    @Column(name = "bill_code")
    private String billCode;
    @Column(name = "bill_name")
    private String billName;
    @Column(name = "bill_com")
    private String billCom;
    @Column(name = "bill_num")
    private Integer billNum;
    @Column(name = "money")
    private Double money;
    @Column(name = "pay")
    private Integer pay;
    @Column(name = "pid")
    private String pid;
    @Column(name = "create_date")
    private Date createDate;
}
