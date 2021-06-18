package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.services.CountryService;

@SpringBootApplication
public class OrmlearnApplication {

	private static final Logger logger = LoggerFactory.getLogger(OrmlearnApplication.class);

	@Autowired
	private CountryService countryService;

	public static void main(String[] args) {
		SpringApplication.run(OrmlearnApplication.class, args);
	}

	@Bean
	CommandLineRunner getAllCountries() {
		return args -> {
			logger.info("START...");
			List<Country> countries = countryService.getAllCountries();
			logger.debug("countries = {}", countries);
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner addCountry() {
		return args -> {
			logger.info("START...");
			countryService.addCountry(new Country("AB", "Arab"));
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner findCountryByCode() {
		return args -> {
			logger.info("START...");
			Country country = countryService.findCountryByCode("AB");
			logger.debug("Country : {}", country);
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner deleteCountryByCode() {
		return args -> {
			logger.info("START...");
			countryService.deleteCountry("AB");
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner findByCharacters() {
		return args -> {
			logger.info("START...By Character");
			countryService.findCountryByCharacter("ou").forEach(c -> logger.info("{}", c));
			logger.info("END...");
		};
	}
	
	@Bean
	CommandLineRunner findUsingSingleCharacter() {
		return args -> {
			logger.info("START...By Character");
			countryService.findCountryUsingSingleCharacter("A").forEach(c -> logger.info("{}", c));
			logger.info("END...");
		};
	}

}
