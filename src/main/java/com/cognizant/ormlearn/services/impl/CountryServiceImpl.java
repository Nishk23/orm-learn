package com.cognizant.ormlearn.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.services.CountryService;
import com.cognizant.ormlearn.services.exception.CountryNotFoundException;

@Service()
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {

		return countryRepository.findAll();
	}

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

		Optional<Country> result = countryRepository.findById(countryCode);

		if (!result.isPresent()) {
			throw new CountryNotFoundException();
		}

		return (result.get());
	}

	@Override
	@Transactional
	public void addCountry(Country country) {

		countryRepository.save(country);
	}

	@Override
	@Transactional
	public void deleteCountry(String code) {

		countryRepository.deleteById(code);
	}

}
