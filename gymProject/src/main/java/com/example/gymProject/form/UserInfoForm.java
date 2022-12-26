package com.example.gymProject.form;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserInfoForm implements Serializable {
	private Integer cardNo;
	private String name;
	private String gender;
	private String id;
	private String phone;
	private String addr;
	private Date startTime;
	private Date endTime;
	private Integer role;
}
