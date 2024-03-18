package ru.geekbrains.homework3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework3.models.AppError;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.models.Issue;
import ru.geekbrains.homework3.models.Reader;
import ru.geekbrains.homework3.services.BookService;
import ru.geekbrains.homework3.services.ReaderService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("reader")
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    /**
     * Gets reader by id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(readerService.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage())
                    ,HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Gets issue list by readerId
     * @param readerId
     * @return
     */
    @GetMapping("/{readerId}/issue")
    public ResponseEntity<?> getIssuesByReaderId(@PathVariable long readerId) {
        try {
            return new ResponseEntity<>(readerService.getIssues(readerId), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Removes reader by id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> removeReaderById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(readerService.removeById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()),
                    HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Created new book
     * @param readerRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<?> createReader(@RequestBody ReaderRequest readerRequest) {
        Reader reader = new Reader(readerRequest.getName());
        return new ResponseEntity<>(readerService.createReader(reader), HttpStatus.CREATED);
    }


}
