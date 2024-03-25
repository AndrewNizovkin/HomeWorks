package ru.geekbrains.homework5.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.homework5.dto.ReaderRequest;
import ru.geekbrains.homework5.mappers.ReaderMapper;
import ru.geekbrains.homework5.model.Book;
import ru.geekbrains.homework5.model.Issue;
import ru.geekbrains.homework5.model.Reader;
import ru.geekbrains.homework5.repository.IssueRepository;
import ru.geekbrains.homework5.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onCreatedDatabase() {
        readerRepository.saveAndFlush(new Reader("Андрей"));
        readerRepository.saveAndFlush(new Reader("Василий"));
        readerRepository.saveAndFlush(new Reader("Константин"));
        readerRepository.saveAndFlush(new Reader("Станислав"));
    }

    /**
     * Gets all readers
     * @return
     */
    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    /**
     * Gets reader by id
     * @param id
     * @return
     */
    public Reader getById(long id) {
        Optional<Reader> optionalReader = readerRepository.findById(id);
        if (optionalReader.isPresent()) {
            return optionalReader.get();
        } else {
            log.info("Не удалось найти читателя с id=" +id);
            throw new NoSuchElementException("Не удалось найти читателя с id=" +id);
        }
    }

    /**
     * Removes reader by id
     * @param id
     */
    @Transactional
    public Reader removeById(long id) {
        Optional<Reader> optionalReader = readerRepository.findById(id);
        if (optionalReader.isEmpty()) {
            log.info("Не удалось найти читателя с id=" + id);
            throw new NoSuchElementException("Не удалось найти читателя с id=" + id);
        }
        readerRepository.deleteById(id);
        return optionalReader.get();
    }

    /**
     * Adds reader to repository
     * @param
     * @return
     */
    @Transactional
    public Reader createReader(ReaderRequest readerRequest) {
        Reader reader = ReaderMapper.toReader(readerRequest);
        readerRepository.saveAndFlush(reader);
        return reader;
    }

    /**
     * Gets issue list by readerId
     * @param readerId
     * @return
     */
    public List<Issue> getIssues(long readerId) {
        if (readerRepository.findById(readerId).isEmpty()) {
            log.info("Не удалось найти читателя с id=" + readerId);
            throw new NoSuchElementException("Не удалось найти читателя с id=" + readerId);
        }

        List<Issue> issues = issueRepository.findAll()
                .stream()
                .filter(issue -> issue.getIdReader() == readerId && issue.getReturned_at() == null)
                .collect(Collectors.toList());

        if (issues.isEmpty()) {
            log.info("Не выдано книг читателю с id=" + readerId);
            throw new NoSuchElementException("Не выдано книг читателю с id=" + readerId);
        }

        return issues;
    }


}
