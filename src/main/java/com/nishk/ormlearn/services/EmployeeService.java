package com.nishk.ormlearn.services;

import java.util.List;

import com.nishk.ormlearn.model.Employee;

public interface EmployeeService {

	Employee findEmployee(int id);
	
	void removeEmployee(int id);

	void saveEmployee(Employee employee);
	
	List<Employee> findAllPermanentEmployees();
	
	double findAverageSalaryofEmployees();
	
	double findAverageSalaryBasedOnDeptId(int id);
	
	List<Employee> getAllEmployeesUsingNativeQuery(); 
}
