package ru.geekbrains.homework3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework3.dto.IssueReport;
import ru.geekbrains.homework3.mappers.IssueMapper;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.models.Reader;
import ru.geekbrains.homework3.repositories.BookRepository;
import ru.geekbrains.homework3.repositories.IssueRepository;
import ru.geekbrains.homework3.repositories.ReaderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class UiService {
    private final BookRepository bookRepository;
    private final IssueRepository isuueRepository;
    private final ReaderRepository readerRepository;

    /**
     * Gets all books
     * @return List books
     */
    public List<Book> getAllBook() {
        return bookRepository.getAll();
    }

    /**
     * Gets all readers
     * @return List readers
     */
    public List<Reader> getAllReaders() {
        return readerRepository.getAll();
    }

    /**
     * Gets issue reports for all issue
     * @return
     */
    public List<IssueReport> getIssueReport() {
        List<IssueReport> reports = new ArrayList<>();

        isuueRepository.getAll().forEach(issue -> reports.add(IssueMapper.toIssueReport(issue,
                bookRepository.getById(issue.getIdBook()),
                readerRepository.getById(issue.getIdReader()))));
        return reports;
    }

    /**
     * Gets reader by id
     * @param readerId
     * @return
     */
    public Reader getReaderById(long readerId) {
        Reader reader = readerRepository.getById(readerId);
        if (reader == null) {
            throw new NoSuchElementException("Нет читателя с id =" + readerId);
        }
        return reader;
    }

    /**
     * Gets book list by readerID
     * @param readerId
     * @return
     */
    public List<Book> getBooksByReaderId(long readerId) {
        List<Book> books = new ArrayList<>();
        isuueRepository.getAll().stream().
        filter(issue -> issue.getIdReader() == readerId && issue.getReturned_at() == null).
        forEach(issueFiltered -> books.add(bookRepository.getById(issueFiltered.getIdBook())));
        return books;
    }

}
