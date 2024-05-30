package com.picafe.team_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.picafe.team_3.service.LoginServiceImpl;

import java.util.logging.Logger;

@SpringBootApplication
public class JavaBackendApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(JavaBackendApplication.class.getName());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(JavaBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			jdbcTemplate.queryForObject("SELECT 1", Integer.class);
			System.out.println("Connected to the database successfully!");
		} catch (Exception e) {
			logger.severe( "Failed to connect to the database: ");
		}
	}
}
