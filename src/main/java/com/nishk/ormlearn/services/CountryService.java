package com.nishk.ormlearn.services;

import java.util.List;

import com.nishk.ormlearn.model.Country;
import com.nishk.ormlearn.services.exception.CountryNotFoundException;

public interface CountryService {

	List<Country> getAllCountries();

	Country findCountryByCode(String countryCode) throws CountryNotFoundException;

	void addCountry(Country country);

	void deleteCountry(String code);

	List<Country> findCountryByCharacter(String name); // double characters

	List<Country> findCountryUsingSingleCharacter(String name);
}
