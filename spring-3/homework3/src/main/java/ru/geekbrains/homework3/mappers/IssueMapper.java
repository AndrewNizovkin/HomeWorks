package ru.geekbrains.homework3.mappers;

import ru.geekbrains.homework3.dto.IssueReport;
import ru.geekbrains.homework3.dto.IssueRequest;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.models.Issue;
import ru.geekbrains.homework3.models.Reader;

public class IssueMapper {

    /**
     * Mapped to Issue from IssueRequest
     * @param issueRequest IssueRequest instance
     * @return Issue instance
     */
    public static Issue toIssue(IssueRequest issueRequest) {
        return new Issue(issueRequest.getReaderId(), issueRequest.getBookId());
    }

    /**
     * Mapped to IssueReport from Issue, Book, Reader
     * @param issue
     * @param book
     * @param reader
     * @return
     */
    public static IssueReport toIssueReport(Issue issue, Book book, Reader reader) {
        return new IssueReport(book.getName(), reader.getName(), issue.getIssued_at(),issue.getReturned_at());
    }


}
