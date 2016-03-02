package com.aditya.exam;

import java.io.Serializable;

public class StudentMarksBean implements Serializable {
	
	public StudentMarksBean() {
		
	}
	
	public static final long serialVersionUID = 1L;
	
	public StudentMarksBean(int id,
					 String firstName,
					 String lastName,
					 String rollNumber,
					 String subject,
					 int semester,
					 int finalmarks,
					 int year) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.rollnumber = rollnumber;		
		this.subject = subject; 
		this.semester = semester; 
		this.finalmarks = finalmarks; 
		this.year = year; 
	}

	public StudentMarksBean(String subject,int semester,int marks1,int marks2,int finalmarks, int studentid)
			 {
		this.subject = subject;
		this.semester = semester;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.finalmarks = finalmarks;
		this.studentid = studentid;
	}

	public StudentMarksBean(String firstname,String rollnumber,String subject,int semester,int marks1,int marks2,int finalmarks, int studentid,String branch,int year)
	 {
		this.firstname = firstname;
		this.rollnumber = rollnumber;
		this.subject = subject;
		this.semester = semester;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.finalmarks = finalmarks;
		this.studentid = studentid;
		this.branch=branch;
		this.year = year;
}
	
	
	
	
	
	
	int id ;
	int studentid;
	int year;
	String firstname;
	String lastname;
	String subject;
	int marks1,marks2,finalmarks;
	int semester;
	String rollnumber;
	String branch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getMarks1() {
		return marks1;
	}

	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}

	public int getFinalmarks() {
		return finalmarks;
	}

	public void setFinalmarks(int finalmarks) {
		this.finalmarks = finalmarks;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}




}
