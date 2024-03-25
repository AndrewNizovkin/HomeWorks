package ru.geekbrains.homework5.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.geekbrains.homework5.dto.IssueRequest;
import ru.geekbrains.homework5.model.Issue;
import ru.geekbrains.homework5.services.IssueService;

import javax.naming.NoPermissionException;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("issue")
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;

    /**
     * Creates new issue
     * @param issueRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest issueRequest) {
        log.info("Поступил запрос на выдачу: readerId={}, bookId={}",
                issueRequest.getReaderId(),
                issueRequest.getBookId());

        try {
            return new ResponseEntity<>(issueService.createIssue(issueRequest), HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (NoPermissionException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());

        }
    }

    /**
     * Gets issue by id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Issue> getById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(issueService.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    /**
     * Closes issue by id
     * @param issueId
     * @return
     */
    @PutMapping("{issueId}")
    public ResponseEntity<Issue> closeById(@PathVariable long issueId) {
        try {
            return new ResponseEntity<>(issueService.closeIssue(issueId), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }



}
