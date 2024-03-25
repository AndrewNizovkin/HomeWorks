package ru.geekbrains.homework5.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.homework5.dto.IssueRequest;
import ru.geekbrains.homework5.mappers.IssueMapper;
import ru.geekbrains.homework5.model.Book;
import ru.geekbrains.homework5.model.Issue;
import ru.geekbrains.homework5.repository.BookRepository;
import ru.geekbrains.homework5.repository.IssueRepository;
import ru.geekbrains.homework5.repository.ReaderRepository;

import javax.naming.NoPermissionException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class IssueService {

    @Value("${application.max-count-book:1}")
    private int value;

    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    /**
     * Create new Issue
     * @param request
     * @return
     * @throws NoPermissionException
     */
    @Transactional
    public Issue createIssue(IssueRequest request) throws NoPermissionException {

        if (bookRepository.findById(request.getBookId()).isEmpty()) {
            log.info("Не удалось найти книгу с id=" + request.getBookId());
            throw new NoSuchElementException("Не удалось найти книгу с id=" + request.getBookId());
        }
        if (readerRepository.findById(request.getReaderId()).isEmpty()) {
            log.info("Не удалось найти читателя с id=" + request.getReaderId());
            throw new NoSuchElementException("Не удалось найти читателя с id=" + request.getReaderId());
        }

        if (issueRepository.findAll().stream().
                filter(x -> x.getIdReader() == request.getReaderId() && x.getReturned_at() == null).count() >= value) {
            log.info("Невозможно выдать книгу читателю с id=" + request.getReaderId());
            throw new NoPermissionException("Невозможно выдать книгу читателю с id=" + request.getReaderId());

        }
        Issue issue = IssueMapper.toIssue(request);
        issueRepository.saveAndFlush(issue);
        return issue;
    }

    /**
     * Close issue
     * @param issueId
     * @return
     */
    @Transactional
    public Issue closeIssue(long issueId) {
        Optional<Issue> optionalIssue = issueRepository.findById(issueId);
        Issue issue1 = issueRepository.getReferenceById(issueId);
        if (optionalIssue.isEmpty()) {
            log.info("Не зарегистрировано выдачи с id=" + issueId);
            throw new NoSuchElementException("Не зарегистрировано выдачи с id=" + issueId);
        }

        Issue issue = issueRepository.getReferenceById(issueId);
        issue.setReturned_at(LocalDateTime.now());
        issueRepository.saveAndFlush(issue);
        return issue;
    }

    /**
     * Gets issue by id
     * @param id
     * @return
     */
    public Issue getById(long id) {
        Optional<Issue> optionalIssue= issueRepository.findById(id);
        if (optionalIssue.isPresent()) {
            return optionalIssue.get();
        } else {
            log.info("Не зарегистрировано выдачи с id=" +id);
            throw new NoSuchElementException("Не зарегистрировано выдачи с id=" + id);
        }
    }
}
