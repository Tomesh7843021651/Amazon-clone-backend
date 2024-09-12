package com.example.julyamazon.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	Date date;
	int userid;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Category(int id, String name, Date date, int userid) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.userid = userid;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", date=" + date + ", userid=" + userid + "]";
	}
	
	

}
