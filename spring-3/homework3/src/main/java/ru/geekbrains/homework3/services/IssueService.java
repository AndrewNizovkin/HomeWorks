package ru.geekbrains.homework3.services;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework3.dto.IssueRequest;
import ru.geekbrains.homework3.mappers.IssueMapper;
import ru.geekbrains.homework3.models.Issue;
import ru.geekbrains.homework3.repositories.BookRepository;
import ru.geekbrains.homework3.repositories.IssueRepository;
import ru.geekbrains.homework3.repositories.ReaderRepository;

import javax.naming.NoPermissionException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class IssueService {
//    @Value("${application.max-count-book:1}")
    private int value = 3;

    private final BookRepository bookRepository;
    private final IssueRepository isuueRepository;
    private final ReaderRepository readerRepository;

    public Issue createIssue(IssueRequest request) throws NoPermissionException {

        if (bookRepository.getById(request.getBookId()) == null) {
            log.info("Не удалось найти книгу с id=" + request.getBookId());
            throw new NoSuchElementException("Не удалось найти книгу с id=" + request.getBookId());
        }
        if (readerRepository.getById(request.getReaderId()) == null) {
            log.info("Не удалось найти читателя с id=" + request.getReaderId());
            throw new NoSuchElementException("Не удалось найти читателя с id=" + request.getReaderId());
        }
        if (isuueRepository.getAll().stream().
                filter(x -> x.getIdReader() == request.getReaderId() && x.getReturned_at() == null).count() >= value) {
            log.info("Невозможно выдать книгу читателю с id=" + request.getReaderId());
            throw new NoPermissionException("Невозможно выдать книгу читателю с id=" + request.getReaderId());

        }
            Issue issue = IssueMapper.toIssue(request);
            isuueRepository.createIssue(issue);
        return issue;
    }

    /**
     * Close issue
     * @param issueId
     * @return
     */
    public Issue closeIssue(long issueId) {
        Issue issue = isuueRepository.getById(issueId);
        if (issue == null) {
            log.info("Не зарегистрировано выдачи с id=" + issueId);
            throw new NoSuchElementException("Не зарегистрировано выдачи с id=" + issueId);
        }
        issue.setReturned_at(LocalDateTime.now());
        return issue;
    }

    /**
     * Gets issue by id
     * @param id
     * @return
     */
    public Issue getById(long id) {
        Issue issue = isuueRepository.getById(id);
        if (issue != null) {
            return issue;
        } else {
            log.info("Не зарегистрировано выдачи с id=" +id);
            throw new NoSuchElementException("Не зарегистрировано выдачи с id=" + id);
        }
    }

}
