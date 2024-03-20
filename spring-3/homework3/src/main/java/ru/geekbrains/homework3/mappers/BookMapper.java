package ru.geekbrains.homework3.mappers;

import ru.geekbrains.homework3.dto.BookRequest;
import ru.geekbrains.homework3.models.Book;

public class BookMapper {
    public static Book toBook(BookRequest bookRequest) {
        return new Book(bookRequest.getName());
    }
}
