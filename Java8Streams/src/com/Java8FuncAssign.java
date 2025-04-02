package com;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8FuncAssign {
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("A", "Z", "HR", 2023, 6000, "1982-10-12", 1));
		employees.add(new Employee("B", "Y", "IT", 2022, 7000, "1990-11-29", 2));
		employees.add(new Employee("C", "X", "HR", 2023, 5000, "1995-01-26", 3));
		employees.add(new Employee("D", "W", "IT", 2021, 8000, "1978-03-24", 4));
		employees.add(new Employee("E", "V", "FINANCE", 2021, 9000, "1962-04-31", 5));
		
		// Predicate to check if employee salary is above 2000
        Predicate<Employee> salaryAbove2000 = employee -> employee.getSalary() > 2000;

        // BiPredicate to check if employee salary is above a given threshold
        BiPredicate<Employee, Double> salaryAboveThreshold = (employee, threshold) -> employee.getSalary() > threshold;

        // Consumer to print employee details
        Consumer<Employee> printEmployee = employee -> System.out.println(employee.toString());

        // Using Predicate to filter and Consumer to print employees with salary above 2000
        System.out.println("Employees with salary above 2000:");
        employees.stream()
                .filter(salaryAbove2000)
                .forEach(printEmployee);
        
        // Using BiPredicate to filter and Consumer to print employees with salary above a given threshold
        double threshold = 2000.0;
        System.out.println("\nEmployees with salary above " + threshold + ":");
        employees.stream()
                .filter(employee -> salaryAboveThreshold.test(employee, threshold))
                .forEach(printEmployee);
        
        
        // 2nd Solution
        // Supplier to generate a 16-character random password
        Supplier<String> passwordSupplier = () -> {
            SecureRandom random = new SecureRandom(); 
            StringBuilder password = new StringBuilder(16);
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            for (int i = 0; i < 16; i++) {
                password.append(characters.charAt(random.nextInt(characters.length())));
            }
            return password.toString();
        };
        
        // Function to convert Employee to User
        Function<Employee, User> employeeToUserFunction = employee -> {
            String yearOfBirth = employee.getDateOfBirth().split("-")[0];//extracts year from date of birth
            String userName = employee.getFirstName() + employee.getLastName() + yearOfBirth + employee.id; //constructs username
            String password = passwordSupplier.get();//generates random string of 16 char with the help of secureRandom
            return new User(employee.id, userName, password); 
        };

        // Creating a list of users from the list of employees
        List<User> users = new ArrayList<>();
        employees.forEach(employee -> users.add(employeeToUserFunction.apply(employee)));

        // Printing the list of users
        System.out.println("List of Users:");
        users.forEach(System.out::println);
        //odwO Xju0 cON8 ndXv

	}

}
