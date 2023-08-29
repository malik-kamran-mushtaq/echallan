package com.test.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.entity.UserEntity;

@Entity
@Table(name = "Challan")
public class ChallanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int challan_no;
	
	
	@Column(nullable = false, length = 30)
	private String name;
	
	@Column(nullable = false, length = 30)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String mobile;
	
	@Column(nullable = false, length = 20)
	private Date date;
	
	@Column(nullable = false, length = 10)
	private String gender;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false, length = 20)
	private String location;
	
	@Column(nullable = false, length = 30)
	private String offence;
	
	@Column(nullable = false)
	private int amount;
	
	@ManyToOne
	@JoinColumn(name = "lic_id")
	//@JsonIgnore
	private UserEntity user1;

	public int getChallan_no() {
		return challan_no;
	}

	public void setChallan_no(int challan_no) {
		this.challan_no = challan_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOffence() {
		return offence;
	}

	public void setOffence(String offence) {
		this.offence = offence;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}



	public UserEntity getUser1() {
		return user1;
	}

	public void setUser1(UserEntity user1) {
		this.user1 = user1;
	}

	public ChallanEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ChallanEntity [challan_no=" + challan_no + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", date=" + date + ", gender=" + gender + ", age=" + age + ", location=" + location + ", offence="
				+ offence + ", amount=" + amount + ", user1=" + user1 + "]";
	}
	
	

}
