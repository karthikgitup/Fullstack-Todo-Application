package com.employee.demo.empentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emptble")
public class EmpEntity {
	@Id
	@Column(name="emp_id",length=50)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empid;
	
	@Column(name="emp_name",length=50)
	private String empname ;
	@Column(name="emp_position",length=50)
	private String position;
	@Column(name="emp_city",length=50)
	private String city;
	@Column(name="emp_salary",length=50)
	private int salary;
	@Override
	public String toString() {
		return "EmpEntity [empid=" + empid + ", empname=" + empname + ", position=" + position + ", city=" + city
				+ ", salary=" + salary + ", getEmpid()=" + getEmpid() + ", getEmpname()=" + getEmpname()
				+ ", getPosition()=" + getPosition() + ", getCity()=" + getCity() + ", getSalary()=" + getSalary()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public EmpEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpEntity(String empname, String position, String city, int salary) {
		super();
		this.empname = empname;
		this.position = position;
		this.city = city;
		this.salary = salary;
	}
	
	public EmpEntity(int empid, String empname, String position, String city, int salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.position = position;
		this.city = city;
		this.salary = salary;
	}
	
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
