package ru.geekbrains.homework3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework3.controllers.IssueRequest;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.models.Issue;
import ru.geekbrains.homework3.repositories.BookRepository;
import ru.geekbrains.homework3.repositories.IssueRepository;
import ru.geekbrains.homework3.repositories.ReaderRepository;

import javax.naming.NoPermissionException;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class IssueService {
    private final BookRepository bookRepository;
    private final IssueRepository isuueRepository;
    private final ReaderRepository readerRepository;

    public Issue createIssue(IssueRequest request) throws NoPermissionException {
        Issue issue = null;

        if (bookRepository.getById(request.getBookId()) == null) {
            log.info("Не удалось найти книгу с id=" + request.getBookId());
            throw new NoSuchElementException("Не удалось найти книгу с id=" + request.getBookId());
        }
        else if (readerRepository.getById(request.getReaderId()) == null) {
            log.info("Не удалось найти читателя с id=" + request.getReaderId());
            throw new NoSuchElementException("Не удалось найти читателя с id=" + request.getReaderId());
        }
        else if (isuueRepository.getAll().stream().
                filter(x -> x.getIdReader() == request.getReaderId()).
                findFirst().
                orElse(null) != null) {
            log.info("Невозможно выдать книгу читателю с id=" + request.getReaderId());
            throw new NoPermissionException("Невозможно выдать книгу читателю с id=" + request.getReaderId());

        } else {
            issue = new Issue(request.getReaderId(), request.getBookId());
            isuueRepository.createIssue(issue);

        }

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
