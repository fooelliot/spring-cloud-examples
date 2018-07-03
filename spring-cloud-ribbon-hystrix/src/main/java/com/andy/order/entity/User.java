package com.andy.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private Integer id;

	private Date birthday;

	private String username;
	
	private String password;
	
	private double salary;

	@Override
	public String toString() {
		return "Users [id=" + id + ", birthday=" + birthday + ", username=" + username + ", password=" + password
				+ ", salary=" + salary + "]";
	}

}

