package com.example.gymProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class GymProjectApplication {
	protected static Logger logger = LoggerFactory.getLogger(GymProjectApplication.class.getName());
	public static void main(String[] args) {
		//SpringApplication.run(GymProjectApplication.class, args);
		//System.out.println("daw");
		logger.debug("sda");
	}

}
