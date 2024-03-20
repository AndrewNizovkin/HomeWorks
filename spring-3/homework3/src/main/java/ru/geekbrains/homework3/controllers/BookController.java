package ru.geekbrains.homework3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.geekbrains.homework3.dto.BookRequest;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.services.BookService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Gets book by id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    /**
     * Removes book by id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Book> removeBookById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(bookService.removeById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    /**
     * Created new book
     * @param bookRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {
        return new ResponseEntity<>(bookService.createBook(bookRequest), HttpStatus.CREATED);
    }
}
