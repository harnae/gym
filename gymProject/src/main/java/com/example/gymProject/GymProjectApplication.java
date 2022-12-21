package com.example.gymProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class GymProjectApplication {
	//protected static Logger logger = LoggerFactory.getLogger(GymProjectApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(GymProjectApplication.class, args);

	}

}
