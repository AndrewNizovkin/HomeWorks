package ru.geekbrains.homework5.mappers;


import ru.geekbrains.homework5.dto.BookDto;
import ru.geekbrains.homework5.model.Book;

import java.util.List;

public class BookMapper {

    /**
     * Mapped to Book from BookDto
     * @param bookDto bookDto instance
     * @return Book instance
     */
    public static Book toBook(BookDto bookDto) {
        return new Book(bookDto.getName());
    }

    /**
     * Mapped to Book from BookDto
     * @param book bookDto instance
     * @return Book instance
     */
    public static BookDto toBookDto(Book book) {
        return new BookDto(book.getName());
    }

    /**
     * Mapped to List<BookDto> from List<BookD>
     * @param bookList
     * @return
     */
    public static List<BookDto> toListDto(List<Book> bookList) {
        return bookList.stream().map(BookMapper::toBookDto).toList();
    }
}
