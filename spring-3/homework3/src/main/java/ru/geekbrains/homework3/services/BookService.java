package ru.geekbrains.homework3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.repositories.BookRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    /**
     * Gets book by id
     * @param id
     * @return
     */
    public Book getById(long id) {
        Book book = bookRepository.getById(id);
        if (book != null) {
            return book;
        } else {
            log.info("Не удалось найти книгу с id=" +id);
            throw new NoSuchElementException("Не удалось найти книгу с id=" +id);
        }
    }

    /**
     * Removes book with id
     * @param id
     */
    public Book removeById(long id) {
        Book book = bookRepository.getById(id);
        if (!bookRepository.removeById(id)) {
            log.info("Не удалось найти книгу с id=" + id);
            throw new NoSuchElementException("Не удалось найти книгу с id=" + id);
        }
        return book;
    }

    /**
     * Adds book to repository
     * @param book
     * @return
     */
    public Book createBook(Book book) {
        bookRepository.addBook(book);
        return book;
    }


}
