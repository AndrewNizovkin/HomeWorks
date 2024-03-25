package ru.geekbrains.homework5.mappers;


import ru.geekbrains.homework5.dto.BookRequest;
import ru.geekbrains.homework5.model.Book;

public class BookMapper {
    public static Book toBook(BookRequest bookRequest) {
        return new Book(bookRequest.getName());
    }
}
