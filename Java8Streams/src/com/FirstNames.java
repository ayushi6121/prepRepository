package com;

import java.util.ArrayList;
import java.util.List;

public class FirstNames {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("A", "Z", "HR", 2023, 6000));
		employees.add(new Employee("B", "Y", "IT", 2022, 7000));
		employees.add(new Employee("C", "X", "HR", 2023, 5000));
		employees.add(new Employee("D", "W", "IT", 2021, 8000));
		employees.add(new Employee("E", "V", "FINANCE", 2021, 9000));

	        // Stream to filter and print first names of employees who joined in 2023
	        employees.stream() //to process the list
	                 .filter(employee -> employee.getJoiningYear() == 2023) //select those employees joined in 2023
	                 .map(Employee::getFirstName)//extracts the first name of filtered employees
	                 .forEach(System.out::println);//print the first name to console
	  }

}
