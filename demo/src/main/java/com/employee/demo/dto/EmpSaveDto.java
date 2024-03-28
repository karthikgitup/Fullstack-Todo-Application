package com.employee.demo.dto;

public class EmpSaveDto {
	private String empname ;
	private String position;
	private String city;
	private int salary;
	public EmpSaveDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmpSaveDto [ empname=" + empname + ", position=" + position + ", city=" + city
				+ ", salary=" + salary + ",  getEmpname()=" + getEmpname()
				+ ", getPosition()=" + getPosition() + ", getCity()=" + getCity() + ", getSalary()=" + getSalary()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	public EmpSaveDto(String empname, String position, String city, int salary) {
		super();
		this.empname = empname;
		this.position = position;
		this.city = city;
		this.salary = salary;
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
