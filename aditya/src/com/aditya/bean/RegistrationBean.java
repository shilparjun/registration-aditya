package com.aditya.bean;

import java.io.Serializable;

public class RegistrationBean implements Serializable {
	
	public RegistrationBean() {
		
	}
	
	public static final long serialVersionUID = 1L;
	
	public RegistrationBean(int id,
					 String firstName,
					 String lastName,
					 String fatherName,
					 String contact,
					 String address,
					 String email,
					 String hobbies,
					 String gender,
					 String group,
					 int year) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName; 
		this.fatherName = fatherName; 
		this.contact = contact; 
		this.address = address; 
		this.email = email; 
		this.hobbies = hobbies; 
		this.gender = gender;
		this.group = group; 
		this.year = year; 
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}	
	
	
	@Override
	public String toString() {
		return "RegistrationBean [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", fatherName=" + fatherName
				+ ", contact=" + contact + ", address=" + address + ", email="
				+ email + ", hobbies=" + hobbies + ", gender=" + gender + "]";
	}
	int id ;
	String firstName;
	String lastName;
	String fatherName;
	String contact;
	String address;
	String email;
	String hobbies;
	String gender ; 
	String group;
	int year;


}
