package ru.geekbrains.homework3.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IssueReport {
    private String bookName;
    private String readerName;
    private LocalDateTime issued_at;
    private  LocalDateTime returned_at;

    public IssueReport(String bookName, String readerName, LocalDateTime issued_at, LocalDateTime returned_at) {
        this.bookName = bookName;
        this.readerName = readerName;
        this.issued_at = issued_at;
        this.returned_at = returned_at;
    }
}
