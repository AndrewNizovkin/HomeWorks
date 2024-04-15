package ru.geekbrains.seminar11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Seminar11Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar11Application.class, args);
	}

}
