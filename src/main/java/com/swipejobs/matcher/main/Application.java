package com.swipejobs.matcher.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.swipejobs.matcher"})
public class Application {

	    public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
}
