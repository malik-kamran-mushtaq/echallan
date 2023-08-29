package com.test.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.entity.ChallanEntity;

@Entity
@Table(name = "User")
public class UserEntity {
	
	@Id
	private int lic_no;
	
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
	
	//(mappedBy = "user1", cascade = CascadeType.ALL)
	@OneToMany (mappedBy = "user1", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ChallanEntity> challanList=new ArrayList<>();
	

	public List<ChallanEntity> getChallanList() {
		return challanList;
	}

	public void setChallanList(List<ChallanEntity> challanList) {
		this.challanList = challanList;
	}

	public int getLic_no() {
		return lic_no;
	}

	public void setLic_no(int lic_no) {
		this.lic_no = lic_no;
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
	

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserEntity [lic_no=" + lic_no + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", age="
				+ age + ", username=" + username + ", password=" + password + ", challanList=" + challanList + "]";
	}

	
	
	
	
	

}
