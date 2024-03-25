package ru.geekbrains.homework5.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.homework5.dto.BookRequest;
import ru.geekbrains.homework5.mappers.BookMapper;
import ru.geekbrains.homework5.model.Book;
import ru.geekbrains.homework5.repository.BookRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onCreatedDatabase() {
        bookRepository.save(new Book("Война и мир"));
        bookRepository.save(new Book("Мастер и Маргарита"));
        bookRepository.save(new Book("Приключения Буратино"));
        bookRepository.save(new Book("Декамерон"));
        bookRepository.save(new Book("Преступление и наказание"));
    }

    /**
     * Get all books
     * @return List Book instances
     */
    public List<Book> getAll() {
        Iterable<Book> iterable = bookRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }

    /**
     * Gets book by id
     * @param id long id
     * @return Book instance
     */
    public Book getById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        } else {
            log.info("Не удалось найти книгу с id=" +id);
            throw new NoSuchElementException("Не удалось найти книгу с id=" +id);
        }
    }

    /**
     * Removes book with id
     * @param id long id
     */
    @Transactional
    public Book removeById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            log.info("Не удалось найти книгу с id=" + id);
            throw new NoSuchElementException("Не удалось найти книгу с id=" + id);
        }
        bookRepository.deleteById(id);
        return bookOptional.get();
    }

    /**
     * Adds book to repository
     * @param bookRequest BookRequest instance
     * @return Book instance
     */
    @Transactional
    public Book createBook(BookRequest bookRequest) {
        Book book = BookMapper.toBook(bookRequest);
        bookRepository.save(book);
        return book;
    }



}
