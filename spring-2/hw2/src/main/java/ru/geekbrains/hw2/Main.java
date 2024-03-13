package ru.geekbrains.hw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 1. Создать spring-boot приложение с помощью https://start.spring.io
 * 2. Создать класс Student с полями: идентификатор, имя, имя группы
 * 3. Создать контроллер, обрабатывающий входящие запросы:
 * 3.1 GET /student/{id} - получить студента по ID
 * 3.2 GET /student - получить всех студентов
 * 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
 * 3.4 GET /group/{groupName}/student - получить всех студентов группы
 * 4. При старте приложения, в программе должно быть создано 5-10 студентов
 */
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

}
