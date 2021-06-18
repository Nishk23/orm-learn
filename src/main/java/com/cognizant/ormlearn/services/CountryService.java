package com.cognizant.ormlearn.services;

import java.util.List;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.services.exception.CountryNotFoundException;

public interface CountryService {

	List<Country> getAllCountries();

	Country findCountryByCode(String countryCode) throws CountryNotFoundException;

	void addCountry(Country country);

	void deleteCountry(String code);

	List<Country> findCountryByCharacter(String name);

	List<Country> findCountryUsingSingleCharacter(String name);
}
