package com.cognizant.ormlearn.services;

import java.util.List;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.services.exception.CountryNotFoundException;

public interface CountryService {

	public List<Country> getAllCountries();

	public Country findCountryByCode(String countryCode) throws CountryNotFoundException;

	public void addCountry(Country country);

	public void deleteCountry(String code);
}
