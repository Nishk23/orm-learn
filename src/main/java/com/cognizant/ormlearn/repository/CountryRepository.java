package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	// NamedQuery can only be used when using EntityManager.

	List<Country> findByName(String name);

	List<Country> findByCode(String code);

	@Query("select c from Country c where c.name like %:name% order by c.name ASC")
	List<Country> findByCustomQuery(String name);

	@Query("select c from Country c where c.name like :name% order by c.name ASC")
	List<Country> findWithSingleCharacter(String name);
}
