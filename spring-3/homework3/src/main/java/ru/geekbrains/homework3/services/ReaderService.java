package ru.geekbrains.homework3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.models.Issue;
import ru.geekbrains.homework3.models.Reader;
import ru.geekbrains.homework3.repositories.IssueRepository;
import ru.geekbrains.homework3.repositories.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final IssueRepository isuueRepository;

    /**
     * Gets reader by id
     * @param id
     * @return
     */
    public Reader getById(long id) {
        Reader reader = readerRepository.getById(id);
        if (reader != null) {
            return reader;
        } else {
            log.info("Не удалось найти читателя с id=" +id);
            throw new NoSuchElementException("Не удалось найти читателя с id=" +id);
        }
    }

    /**
     * Removes reader by id
     * @param id
     */
    public Reader removeById(long id) {
        Reader reader = readerRepository.getById(id);
        if (!readerRepository.removeById(id)) {
            log.info("Не удалось найти читателя с id=" + id);
            throw new NoSuchElementException("Не удалось найти читателя с id=" + id);
        }
        return reader;
    }

    /**
     * Adds reader to repository
     * @param
     * @return
     */
    public Reader createReader(Reader reader) {
        readerRepository.addReader(reader);
        return reader;
    }

    /**
     * Gets issue list by readerId
     * @param readerId
     * @return
     */
    public List<Issue> getIssues(long readerId) {
        if (readerRepository.getById(readerId) == null) {
            log.info("Не удалось найти читателя с id=" + readerId);
            throw new NoSuchElementException("Не удалось найти читателя с id=" + readerId);
        }

        List<Issue> issues = isuueRepository.getAll()
                .stream()
                .filter(issue -> issue.getIdReader() == readerId)
                .collect(Collectors.toList());

        if (issues.isEmpty()) {
            log.info("Не выдано книг читателю с id=" + readerId);
            throw new NoSuchElementException("Не выдано книг читателю с id=" + readerId);
        }



        return issues;
    }


}
