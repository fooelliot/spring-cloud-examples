package com.andy.hystrix.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

	private Integer id;

	private String username;

	private String password;

	private Date birthday;

	private double salary;

	public User(Integer id, Date birthday, String username, String password, double salary) {
		this.id = id;
		this.birthday = birthday;
		this.username = username;
		this.password = password;
		this.salary = salary;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", birthday=" + birthday + ", username=" + username + ", password=" + password
				+ ", salary=" + salary + "]";
	}

}

