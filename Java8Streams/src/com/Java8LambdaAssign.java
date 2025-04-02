package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Java8LambdaAssign {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("A", "Z", "HR", 2023, 6000, "1982-10-12", 1));
		employees.add(new Employee("B", "Y", "IT", 2022, 7000, "1990-11-29", 2));
		employees.add(new Employee("C", "X", "HR", 2023, 5000, "1995-01-26", 3));
		employees.add(new Employee("D", "W", "IT", 2021, 8000, "1978-03-24", 4));
		employees.add(new Employee("E", "V", "FINANCE", 2021, 9000, "1962-04-31", 5));
		
		employees.sort(Comparator.comparingInt(e ->
									Integer.parseInt(e.getDateOfBirth().split("-")[1]))); // sorts employee by extracting month 

        System.out.println("Employees sorted by month of birth:");
        employees.forEach(System.out::println);
        
        List<User> users = new ArrayList<>();
        users.add(new User(1, "BY19902", "password123"));
        users.add(new User(2, "DW19784", "password456"));
        
        // Thread to print employees
        Thread employeeThread = new Thread(() -> {
            System.out.println("Employees:");
            employees.forEach(System.out::println);
        });

        // Thread to print users
        Thread userThread = new Thread(() -> {
            System.out.println("Users:");
            users.forEach(System.out::println);
        });

        // Start threads
        employeeThread.start();
        userThread.start();
        
        // Defining a UserNameGenerator using Lambda
        UserNameGenerator userNameGenerator = (firstName, lastName, yearOfBirth, id) ->
                firstName + lastName + yearOfBirth + id;
        
        List<User> usersList = new ArrayList<>();
        employees.forEach(employee -> {
            String yearOfBirth = employee.getDateOfBirth().split("-")[0];
            String userName = userNameGenerator.generate(employee.getFirstName(), employee.getLastName(), yearOfBirth, employee.id);
            usersList.add(new User(employee.id, userName, employee.getDepartment() + yearOfBirth));
        });

        // Printing Users
        System.out.println("Users:");
        usersList.forEach(System.out::println);

	}

}
