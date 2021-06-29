package com.nishk.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nishk.ormlearn.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}
