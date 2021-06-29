package com.orm.ormlearn.services;

import com.orm.ormlearn.model.Skill;

public interface SkillService {

	Skill findSkill(int id);
	
	void saveSkill(Skill skill);
}
