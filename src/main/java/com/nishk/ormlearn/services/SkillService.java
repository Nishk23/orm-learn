package com.nishk.ormlearn.services;

import com.nishk.ormlearn.model.Skill;

public interface SkillService {

	Skill findSkill(int id);
	
	void saveSkill(Skill skill);
}
