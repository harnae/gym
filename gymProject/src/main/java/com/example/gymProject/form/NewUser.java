package com.example.gymProject.form;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of="username")
@ToString
public class NewUser {
	private String username;
	private String name;
	private String password;
	private String phone;
	private String addr;
	private Date startTime;
	private Date endTime;
	private int role;
}
