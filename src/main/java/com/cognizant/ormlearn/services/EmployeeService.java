package com.cognizant.ormlearn.services;

import com.cognizant.ormlearn.model.Employee;

public interface EmployeeService {

	Employee findEmployee(int id);
	
	void removeEmployee(int id);

	void saveEmployee(Employee employee);
}
