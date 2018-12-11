package com.tascioglu.sefa.hibernate.tutorial.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tascioglu.sefa.hibernate.tutorial.utils.DateUtils;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "first_name")
	private String firstname;

	
	@Column(name = "last_name")
	private String lastname;
	
	@Column(name = "date_of_birth")
	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column
	public String email;

	public Student(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public Student(String firstname, String lastname, Date dateOfBirth, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}


	public Student() {
		
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "date "+ DateUtils.formatDate(dateOfBirth) +", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
