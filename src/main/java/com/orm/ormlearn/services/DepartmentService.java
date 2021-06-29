package com.orm.ormlearn.services;

import com.orm.ormlearn.model.Department;

public interface DepartmentService {

	Department findDepartment(int id);
	
	void saveDepartment(Department department);
}
