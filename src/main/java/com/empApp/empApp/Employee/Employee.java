package com.empApp.empApp.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	@Size(max = 13, message = "Max 13 charecters allowed")
	private String phno;
	private String city;
	private String gender;

	public Employee(int id, String firstname, String lastname, String phno, String city, String gender) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phno = phno;
		this.city = city;
		this.gender = gender;
	}

	public Employee() {
		super();
		this.id = 0;
		this.firstname = "firstname";
		this.lastname = "lastname";
		this.phno = "phno";
		this.city = "city";
		this.gender = "gender";
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

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", phno=" + phno + ", city=" + city
				+ ", gender=" + gender + "]";
	}
}
