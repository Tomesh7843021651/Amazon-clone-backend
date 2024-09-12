package com.example.julyamazon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String username;
	String password;
	int accountType; // 1-admin , 2-seller, 3-Buyer
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", accountType=" + accountType + "]";
	}
	
	

}
