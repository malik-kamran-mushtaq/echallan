package com.test.entity;

import java.sql.Date;

import javax.persistence.Column;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Licence")
public class LicenceEntity {
	
	@Id
	private int lic_no;
	
	@Column(nullable = false, length = 20)
	private Date issue_date;
	
	@Column(nullable = false, length = 20)
	private Date valid_till;
	
	@Column(nullable = false, length = 30)
	private String username;

	public int getLic_no() {
		return lic_no;
	}

	public void setLic_no(int lic_no) {
		this.lic_no = lic_no;
	}

	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	public Date getValid_till() {
		return valid_till;
	}

	public void setValid_till(Date valid_till) {
		this.valid_till = valid_till;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LicenceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LicenceEntity [lic_no=" + lic_no + ", issue_date=" + issue_date + ", valid_till=" + valid_till
				+ ", username=" + username + "]";
	}
	

}
