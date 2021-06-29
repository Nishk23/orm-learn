package com.nishk.ormlearn;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nishk.ormlearn.model.Country;
import com.nishk.ormlearn.model.Department;
import com.nishk.ormlearn.model.Employee;
import com.nishk.ormlearn.model.Skill;
import com.nishk.ormlearn.model.Stock;
import com.nishk.ormlearn.services.CountryService;
import com.nishk.ormlearn.services.DepartmentService;
import com.nishk.ormlearn.services.EmployeeService;
import com.nishk.ormlearn.services.SkillService;
import com.nishk.ormlearn.services.StockService;

@SpringBootApplication
public class OrmlearnApplication {

	private static final Logger logger = LoggerFactory.getLogger(OrmlearnApplication.class);

	@Autowired
	private CountryService countryService;

	@Autowired
	private StockService stockService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private SkillService skillService;

	public static void main(String[] args) {
		
		SpringApplication.run(OrmlearnApplication.class, args);
	}

	@Bean
	CommandLineRunner testGetAllCountries() {
		return args -> {
			logger.info("START...");
			List<Country> countries = countryService.getAllCountries();
			logger.debug("countries = {}", countries);
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner testAddCountry() {
		return args -> {
			logger.info("START...");
			countryService.addCountry(new Country("AB", "Arab"));
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner testFindCountryByCode() {
		return args -> {
			logger.info("START...");
			Country country = countryService.findCountryByCode("CW");
			logger.debug("Country : {}", country);
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner testDeleteCountryByCode() {
		return args -> {
			logger.info("START...");
			countryService.deleteCountry("AB");
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner testFindByCharacters() {
		return args -> {
			logger.info("START...By Character");
			countryService.findCountryByCharacter("ou").forEach(c -> logger.info("{}", c));
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner testFindUsingSingleCharacter() {
		return args -> {
			logger.info("START...By Character");
			countryService.findCountryUsingSingleCharacter("A").forEach(c -> logger.info("{}", c));
			logger.info("END...");
		};
	}

	@Bean
	CommandLineRunner testGetAllStockDetails() {
		return args -> {
			logger.info("START... for getAllStockDetails");
			stockService.getAllStockDetails().forEach(c -> logger.info("{}", c));
			logger.info("END... for getAllStockDetails");
		};
	}

	@Bean
	CommandLineRunner testFindStockUsingCode() {
		return args -> {
			logger.info("START... for findStockUsingCode");
			stockService.findStockUsingCode("GOOGL").forEach(c -> logger.info("{}", c));
			logger.info("END... for findStockUsingCode");
		};
	}

	@Bean
	CommandLineRunner testFindFBStockInSep19() {
		return args -> {
			logger.info("START... for findFBStockInSep19");
			List<Stock> stockInSep19 = stockService.findFBStockInSep19("FB",
					new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-01"),
					new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-30"));
			stockInSep19.forEach(c -> logger.info("{}", c));
			logger.info("END... for findFBStockInSep19");
		};
	}

	@Bean
	CommandLineRunner testFindGoogleStockGreaterThan1250() {
		return args -> {
			logger.info("START... for findGoogleStockGreaterThan1250");
			stockService.findGoogleStockGreaterThan1250("GOOGL", 1250).forEach(c -> logger.info("{}", c));
			logger.info("END... for findGoogleStockGreaterThan1250");
		};
	}

	@Bean
	CommandLineRunner testFindTop3VolumeStock() {
		return args -> {
			logger.info("START... for findTop3VolumeStock");
			stockService.findTop3VolumeStock().forEach(c -> logger.info("{}", c));
			logger.info("END... for findTop3VolumeStock");
		};
	}

	@Bean
	CommandLineRunner testFindLowest3NetflixStocks() {
		return args -> {
			logger.info("START... for findLowest3NetflixStocks");
			stockService.findLowest3NetflixStocks("NFLX").forEach(c -> logger.info("{}", c));
			logger.info("END... for findLowest3NetflixStocks");
		};
	}

	@Bean
	CommandLineRunner testFindEmployee() {
		return args -> {
			logger.info("START... for Employee");
			Employee employee = employeeService.findEmployee(1);
			logger.info("Employee Details -> {}", employee);
			logger.info("END... for Employee");
		};
	}

	@Bean
	CommandLineRunner testFindDepartment() {
		return args -> {
			logger.info("START... for Department");
			Department department = departmentService.findDepartment(1);
			logger.info("Department Details -> {}", department);
			logger.info("END... for Department");
		};
	}

	@Bean
	CommandLineRunner testFindSkill() {
		return args -> {
			logger.info("START... for Skill");
			Skill skill = skillService.findSkill(2);
			logger.info("Skill Details -> {}", skill);
			logger.info("END... for Skill");
		};
	}

	@Bean
	CommandLineRunner testGetEmployee() {
		return args -> {
			logger.info("START... for Get Employee");
			Employee employee = employeeService.findEmployee(2);
			logger.debug("Employee -> {}", employee);
			logger.debug("Department -> {}", employee.getDepartment());
			logger.debug("Skills -> {}", employee.getSkillList());
			logger.info("END... Get Employee");
		};
	}

	@Bean
	CommandLineRunner testAddEmployee() {
		return args -> {
			logger.info("START... for Add Employee");
			Employee.builder().name("Nishanth").salary(500000.00).permanent(true)
					.dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-01")).build();
			Department department = departmentService.findDepartment(3);
			Employee employee = Employee.builder().name("Nithin").salary(700000.00).permanent(false)
					.dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1993-07-02")).department(department).build();
			employeeService.saveEmployee(employee);
			logger.info("Employee Details -> {}", employee);
			logger.info("END... for Add Employee");
		};
	}

	@Bean
	CommandLineRunner testUpdateEmployee() {
		return args -> {
			logger.info("START... for Update Employee");
			Employee employee = employeeService.findEmployee(11);
			Department department = departmentService.findDepartment(1);
			employee.setDepartment(department);
			employeeService.saveEmployee(employee);
			logger.info("Employee Details -> {}", employee);
			logger.info("END... for Update Employee");
		};
	}

	@Bean
	CommandLineRunner testDeleteEmployee() {
		return args -> {
			logger.info("START... for Delete Employee");
			employeeService.removeEmployee(11);
			logger.info("END... for Delete Employee");
		};
	}
	
	@Bean
	CommandLineRunner testGetDepartment() {
		return args -> {
			logger.info("START... for Get Department");
			Department department = departmentService.findDepartment(1);
			logger.info("Department -> {}", department);
			logger.info("Employee List -> {}", department.getEmployeeList());
			logger.info("END... for Get Department");
		};
	}
	
	@Bean
	CommandLineRunner testAddSkillToEmployee() {
		return args -> {
			logger.info("START... for Add Skill To Employee");
			Employee employee = employeeService.findEmployee(1);
			Skill skill = skillService.findSkill(3);
			employee.getSkillList().add(skill);
			employeeService.saveEmployee(employee);
			logger.info("END... for Add Skill To Employee");
		};
	}

	@Bean
	CommandLineRunner testGetAllPermanentEmployees() {
		return args -> {
			logger.info("START... Permanent Employees");
			List<Employee> employees = employeeService.findAllPermanentEmployees();
			logger.debug("Permanent Employees -> {}", employees);
			employees.forEach(e -> logger.debug("Skills -> {}", e.getSkillList()));
			logger.info("END... Permanent Employees");
		};
	}

	@Bean
	CommandLineRunner testGetAverageSalary() {
		return args -> {
			logger.info("START... Get Average Salary of Employees");
			double salary = employeeService.findAverageSalaryofEmployees();
			logger.info("Average Salary : {}", salary);
			logger.info("END... Get Average Salary of Employees");
		};
	}
	
	@Bean
	CommandLineRunner testGetAverageSalaryBasedOnDeptId() {
		return args -> {
			logger.info("START... Get Average Salary based on Dept id");
			double salary = employeeService.findAverageSalaryBasedOnDeptId(3);
			logger.info("Average Salary : {}", salary);
			logger.info("END... Get Average Salary based on Dept id");
		};
	}

	@Bean
	CommandLineRunner testGetAllEmployeesUsingNativeQuery() {
		return args -> {
			logger.info("START... All Employees Using Native Query");
			employeeService.getAllEmployeesUsingNativeQuery().forEach(e -> logger.info("Employees -> {}", e));
			logger.info("END... All Employees Using Native Query");
		};
	}

}
