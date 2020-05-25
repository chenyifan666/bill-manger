package com.cyf.billmanger.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "role")
@Data
@Entity
public class Role {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
