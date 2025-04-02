package com;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String department;
	private int joiningYear;
	private double salary;
	private String dateOfBirth;
	public int id;
	
	public Employee(String firstName, String lastName, String department, int joiningYear, 
			double salary, String dateOfBirth, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department=department;
		this.joiningYear = joiningYear;
		this.salary=salary;
		this.dateOfBirth=dateOfBirth;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getJoiningYear() {
		return joiningYear;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department
				+ ", joiningYear=" + joiningYear + ", salary=" + salary  + ", dateOfBirth=" + dateOfBirth + 
				"id=" + id +"]";
	}
	
}
