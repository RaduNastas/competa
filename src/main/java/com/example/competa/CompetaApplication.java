package com.example.competa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication // отключить Security автоконфигурацию - (exclude = { SecurityAutoConfiguration.class })

public class CompetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompetaApplication.class, args);
	}

}
