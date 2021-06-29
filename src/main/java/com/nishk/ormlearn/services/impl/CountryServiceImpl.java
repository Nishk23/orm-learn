package com.nishk.ormlearn.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishk.ormlearn.model.Country;
import com.nishk.ormlearn.repository.CountryRepository;
import com.nishk.ormlearn.services.CountryService;
import com.nishk.ormlearn.services.exception.CountryNotFoundException;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getAllCountries() {

		return countryRepository.findAll();
	}

	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

		Optional<Country> result = countryRepository.findById(countryCode);

		if (!result.isPresent()) {
			throw new CountryNotFoundException();
		}

		return (result.get());
	}

	@Override
	public void addCountry(Country country) {

		countryRepository.save(country);
	}

	@Override
	public void deleteCountry(String code) {

		countryRepository.deleteById(code);
	}

	@Override
	public List<Country> findCountryByCharacter(String name) {

		return countryRepository.findByCustomQuery(name);
	}

	@Override
	public List<Country> findCountryUsingSingleCharacter(String name) {

		return countryRepository.findWithSingleCharacter(name);
	}

}
