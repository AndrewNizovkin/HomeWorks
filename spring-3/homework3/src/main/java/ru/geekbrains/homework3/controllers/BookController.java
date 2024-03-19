package ru.geekbrains.homework3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework3.models.AppError;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.repositories.BookRepository;
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
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage())
                    ,HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Removes book by id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> removeBookById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(bookService.removeById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Created new book
     * @param bookRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequest bookRequest) {
//        Book book = new Book(bookRequest.getName());
        return new ResponseEntity<>(bookService.createBook(bookRequest), HttpStatus.CREATED);
    }
}
