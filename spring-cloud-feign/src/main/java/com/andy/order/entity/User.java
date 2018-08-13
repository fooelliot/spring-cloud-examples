package com.andy.order.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: lyon
 * @since: 2018-02-13
 **/
@Data
public class User {

    private Integer id;

    private Date birthday;

    private String username;

    private String password;

    private double salary;

}

