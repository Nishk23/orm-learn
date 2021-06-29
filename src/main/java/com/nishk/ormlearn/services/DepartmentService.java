package com.nishk.ormlearn.services;

import com.nishk.ormlearn.model.Department;

public interface DepartmentService {

	Department findDepartment(int id);
	
	void saveDepartment(Department department);
}
