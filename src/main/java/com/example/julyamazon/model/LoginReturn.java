package com.example.julyamazon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class LoginReturn {
	int id;
	int accountType;
	String errorMessage;
	
	public LoginReturn(int id, int accountType, String errorMessage) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.errorMessage = errorMessage;
	}
	
	public LoginReturn() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "LoginReturn [id=" + id + ", accountType=" + accountType + ", errorMessage=" + errorMessage + "]";
	}

}
