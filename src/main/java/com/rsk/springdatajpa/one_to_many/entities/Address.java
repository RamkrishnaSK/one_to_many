package com.rsk.springdatajpa.one_to_many.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int addrid;
	private int flat; 
	private String city;
	private String country;
	
	@ManyToOne
	@JoinColumn(name = "eid")
	private Employee employee;  
	
	public int getFlat() {
		return flat;
	}
	public void setFlat(int flat) {
		this.flat = flat;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
