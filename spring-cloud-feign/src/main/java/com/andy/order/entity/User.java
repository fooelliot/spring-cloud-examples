package com.andy.order.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private Date birthday;

    private String username;

    private String password;

    private double salary;

}

