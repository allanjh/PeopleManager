package com.allanjhonny.peoplemanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

import com.allanjhonny.peoplemanager.services.DBService;

@Configuration
@Profile("test")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instatiateDatabase() throws ParseException {
		
		if (!"update".equals(strategy)) {
			return false;
		}
		System.out.println("----------------- Instanciando DEV DBService");
		dbService.instantiateTestDatabase();
		return true;
		
		
	}

}
