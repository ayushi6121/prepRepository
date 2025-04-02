package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamAssign {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("A", "Z", "HR", 2023, 6000, "1982-10-12", 1));
		employees.add(new Employee("B", "Y", "IT", 2022, 7000, "1990-11-29", 2));
		employees.add(new Employee("C", "X", "HR", 2023, 5000, "1995-01-26", 3));
		employees.add(new Employee("D", "W", "IT", 2021, 8000, "1978-03-24", 4));
		employees.add(new Employee("E", "V", "FINANCE", 2021, 9000, "1962-04-31", 5));
		
		  // Stream to filter and print first names of employees who joined in 2023
        employees.stream() //to process the list
                 .filter(employee -> employee.getJoiningYear() == 2023) //select those employees joined in 2023
                 .map(Employee::getFirstName)//extracts the first name of filtered employees
                 .forEach(System.out::println);//print the first name to console
		
		String targetDepartment = "IT";

        // Filter employees by department and calculate statistics
        DoubleSummaryStatistics stats = employees.stream() //process the list of employees
                                              .filter(employee -> employee.getDepartment().equals(targetDepartment))//selects only employees belonging to the specified department
                                              .collect(Collectors.summarizingDouble(Employee::getSalary));//calculates statistics including count, minimum, maximum, sum, and average of salaries

        // Print the results
        System.out.println("Department: " + targetDepartment);
        System.out.println("Count: " + stats.getCount());
        System.out.println("Min Salary: " + stats.getMin());
        System.out.println("Max Salary: " + stats.getMax());
        System.out.println("Sum of Salaries: " + stats.getSum());
        System.out.println("Average Salary: " + stats.getAverage());
        
        
        // Filter out targetDepartment and sort by firstName
        employees.stream()//process the list of employees
        .filter(employee -> !employee.getDepartment().equals(targetDepartment))//Excludes employees belonging to the target department 
        .sorted((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName()))//sorts employees based on their firstname
        .forEach(System.out::println);
        
        // Increment salary by 10% for employees in the target department
        employees.stream()
                 .filter(employee -> employee.getDepartment().equals(targetDepartment))
                 .forEach(employee -> employee.setSalary(employee.getSalary() * 1.10));

        // Print updated employee details
        employees.forEach(System.out::println);
        
        // Create comma-separated list of first names ordered by date of birth
        String firstNamesList = employees.stream()
                                         .sorted(Comparator.comparing(Employee::getDateOfBirth))//to order employees by their date of birth.
                                         .map(Employee::getFirstName)//extracts the first name of each employee.
                                         .collect(Collectors.joining(", "));//combines the first names into a single comma-separated string

        // Print the result
        System.out.println(firstNamesList);


	}

}
