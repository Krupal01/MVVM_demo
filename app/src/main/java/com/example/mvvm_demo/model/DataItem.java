package com.example.mvvm_demo.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DataItem{
	private String website;
//	private Address address;
//	private Company company;
	private String phone;
	private String name;
	@PrimaryKey(autoGenerate = false)
	private int id;
	private String email;
	private String username;

	public String getWebsite(){
		return website;
	}

	public String getPhone(){
		return phone;
	}

	public String getName(){
		return name;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}

//	public Company getCompany(){
//		return company;
//	}
//	public Address getAddress(){
//		return address;
//	}
//
//	public DataItem(String website, String phone, String name, int id, String email, String username) {
//		this.website = website;
//		this.phone = phone;
//		this.name = name;
//		this.id = id;
//		this.email = email;
//		this.username = username;
//	}
}
