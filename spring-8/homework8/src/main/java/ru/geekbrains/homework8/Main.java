package ru.geekbrains.homework8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);

		Handler handler = context.getBean(Handler.class);
		int N = 1000000;
		System.out.println("Число Фибоначчи " + N + " = " + handler.fib(N));
	}

}
