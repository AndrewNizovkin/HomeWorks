package ru.geekbrains.homework3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework3.dto.BookRequest;
import ru.geekbrains.homework3.mappers.BookMapper;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.repositories.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    /**
     * Get all books
     * @return List Book instances
     */
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    /**
     * Gets book by id
     * @param id long id
     * @return Book instance
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
     * @param id long id
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
     * @param bookRequest BookRequest instance
     * @return Book instance
     */
    public Book createBook(BookRequest bookRequest) {
        Book book = BookMapper.toBook(bookRequest);
        bookRepository.addBook(book);
        return book;
    }


}
