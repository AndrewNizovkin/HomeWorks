package ru.geekbrains.homework3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. Доделать сервис управления книгами:
 * 1.1 Реализовать контроллер по управлению книгами с ручками:
 * * GET /book/{id} - получить описание книги,
 * * DELETE /book/{id} - удалить книгу,
 * * POST /book - создать книгу
 * 1.2 Реализовать контроллер по управлению читателями (аналогично контроллеру с книгами из 1.1)
 * 1.3 В контроллере IssueController добавить ресурс GET /issue/{id} - получить описание факта выдачи
 * 2.1 В сервис IssueService добавить проверку, что у пользователя на руках нет книг.
 * * Если есть - не выдавать книгу (статус ответа - 409 Conflict)
 * 2.2 В сервис читателя добавить ручку
 * * GET /reader/{id}/issue - вернуть список всех выдачей для данного читателя
 */
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
