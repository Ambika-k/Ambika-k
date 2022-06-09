package com.zensar.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	private int empId;
	private String empName;
	private int empSalary;
	
	private Departemnt department;
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, int empSalary, Departemnt department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.department = department;
	}
	
	public Employee(Departemnt department) {
		super();
		this.department = department;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	public Departemnt getDepartment() {
		return department;
	}
	@Autowired
	@Qualifier("department1")
	public void setDepartment(Departemnt department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", department="
				+ department + "]";
	}
	
}
