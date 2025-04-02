Find employee name and their manager name from the Employee table

	SELECT e.name AS EmployeeName, m.name AS ManagerName
	FROM Employee e
	LEFT JOIN Employee m ON e.managerId = m.id; -- manager is also an employee

Find one employee from each department who is getting the highest salary within their department
	SELECT e.name AS EmployeeName, e.departmentId, e.salary
	FROM Employee e
	WHERE e.salary = ( -- subquery ensures that only employee having highest salary ineach department will return
	    SELECT MAX(e2.salary) -- give the highest salary
	    FROM Employee e2
	    WHERE e2.departmentId = e.departmentId -- employees belongs to same department
	);

Delete duplicate rows from a table while keeping one instance

	DELETE FROM Employee
	WHERE id NOT IN ( --deletes all rows except the ones with the minimum id
	    SELECT MIN(id) -- to find the minimum id for each group of duplicate rows 
	    FROM Employee
	    GROUP BY name, managerId -- return 1unique record for the set name, managerId
	);


