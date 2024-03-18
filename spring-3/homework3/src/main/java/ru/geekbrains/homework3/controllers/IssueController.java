package ru.geekbrains.homework3.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework3.models.AppError;
import ru.geekbrains.homework3.models.Issue;
import ru.geekbrains.homework3.services.IssueService;

import javax.naming.NoPermissionException;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("issue")
@RequiredArgsConstructor
public class IssueController {
//    @Autowired
    IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    /**
     * Creates new issue
     * @param issueRequest
     * @return
     */
    @PostMapping
    public ResponseEntity<?> issueBook(@RequestBody IssueRequest issueRequest) {
        log.info("Поступил запрос на выдачу: readerId={}, bookId={}",
                issueRequest.getReaderId(),
                issueRequest.getBookId());

        try {
            return new ResponseEntity<>(issueService.createIssue(issueRequest), HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage()),
                    HttpStatus.NOT_FOUND);
        } catch (NoPermissionException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.CONFLICT.value(),
                    e.getMessage()),
                    HttpStatus.CONFLICT);

        }
    }

    /**
     * Gets issue by id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(issueService.getById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    e.getMessage())
                    ,HttpStatus.NOT_FOUND);
        }
    }

}
