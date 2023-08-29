package com.test.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Police")
public class PoliceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_id;

	@Column(nullable = false, length = 30)
	private String name;

	@Column(nullable = false, length = 20)
	private Date dob;

	@Column(nullable = false, length = 10)
	private String gender;

	@Column(nullable = false, length = 10)
	private int age;

	@Column(unique = true)
	private String username;

	@Column(nullable = false, length = 20)
	private String password;

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PoliceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PoliceEntity [emp_id=" + emp_id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", age="
				+ age + ", username=" + username + ", password=" + password + "]";
	}

}
