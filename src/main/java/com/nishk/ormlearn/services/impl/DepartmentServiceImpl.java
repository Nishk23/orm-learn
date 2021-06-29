package com.nishk.ormlearn.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishk.ormlearn.model.Department;
import com.nishk.ormlearn.repository.DepartmentRepository;
import com.nishk.ormlearn.services.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department findDepartment(int id) {

		return departmentRepository.findById(id).get();
	}

	@Override
	public void saveDepartment(Department department) {

		departmentRepository.save(department);
	}

}
