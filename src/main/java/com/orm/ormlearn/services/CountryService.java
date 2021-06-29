package com.orm.ormlearn.services;

import java.util.List;

import com.orm.ormlearn.model.Country;
import com.orm.ormlearn.services.exception.CountryNotFoundException;

public interface CountryService {

	List<Country> getAllCountries();

	Country findCountryByCode(String countryCode) throws CountryNotFoundException;

	void addCountry(Country country);

	void deleteCountry(String code);

	List<Country> findCountryByCharacter(String name); // double characters

	List<Country> findCountryUsingSingleCharacter(String name);
}
