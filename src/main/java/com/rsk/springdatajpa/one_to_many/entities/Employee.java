package com.rsk.springdatajpa.one_to_many.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int empid;
	private String empname; 
	private double empsalary;  
	private boolean empmarital;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)   
	private List<Address> empaddress;
	 
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}
	public boolean isEmpmarital() {
		return empmarital;
	}
	public void setEmpmarital(boolean empmarital) {
		this.empmarital = empmarital;
	}
	public List<Address> getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(List<Address> empaddress) {
		this.empaddress = empaddress;
	}
	
}
