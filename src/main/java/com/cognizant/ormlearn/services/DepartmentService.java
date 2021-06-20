package com.cognizant.ormlearn.services;

import com.cognizant.ormlearn.model.Department;

public interface DepartmentService {

	Department findDepartment(int id);
	
	void saveDepartment(Department department);
}
