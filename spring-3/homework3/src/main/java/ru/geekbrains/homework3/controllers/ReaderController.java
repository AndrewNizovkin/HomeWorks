package ru.geekbrains.homework3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.geekbrains.homework3.dto.ReaderRequest;
import ru.geekbrains.homework3.models.Issue;
import ru.geekbrains.homework3.models.Reader;
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
    public ResponseEntity<Reader> getById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(readerService.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    /**
     * Gets issue list by readerId
     * @param readerId
     * @return
     */
    @GetMapping("/{readerId}/issue")
    public ResponseEntity<List<Issue>> getIssuesByReaderId(@PathVariable long readerId) {
        try {
            return new ResponseEntity<>(readerService.getIssues(readerId), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    /**
     * Removes reader by id
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Reader> removeReaderById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(readerService.removeById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    /**
     * Created new book
     * @param readerRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<Reader> createReader(@RequestBody ReaderRequest readerRequest) {
        return new ResponseEntity<>(readerService.createReader(readerRequest), HttpStatus.CREATED);
    }


}
