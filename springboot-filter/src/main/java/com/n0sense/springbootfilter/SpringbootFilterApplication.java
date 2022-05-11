package com.n0sense.springbootfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.n0sense.springbootfilter")
public class SpringbootFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFilterApplication.class, args);
	}

}
