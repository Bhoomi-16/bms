package com.cruds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
  private long id;
	
	@Column(unique=true)
  private String userId;
	
	@Column(nullable=false,length=100)
  private String password;
	
	@Column(nullable=false,length=25)
	  private String role;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String userId, String password, String role) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.role = role;
	}


}
