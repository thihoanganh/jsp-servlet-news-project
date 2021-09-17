package com.tintuc24h.models;

import java.sql.Timestamp;

public class User {
	public Integer Id;
	public String Name;
	public String Username;
	public Boolean Gender;
	public Boolean Block;
	public String Password;
	public String Email;
	public Timestamp createDate;
	public String Role;
	
	
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Boolean getGender() {
		return Gender;
	}
	public void setGender(Boolean gender) {
		Gender = gender;
	}
	public Boolean getBlock() {
		return Block;
	}
	public void setBlock(Boolean block) {
		Block = block;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
