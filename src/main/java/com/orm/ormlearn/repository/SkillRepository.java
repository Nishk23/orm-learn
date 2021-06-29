package com.orm.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orm.ormlearn.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	
}
