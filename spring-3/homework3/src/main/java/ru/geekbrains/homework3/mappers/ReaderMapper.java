package ru.geekbrains.homework3.mappers;

import ru.geekbrains.homework3.dto.ReaderRequest;
import ru.geekbrains.homework3.models.Reader;

public class ReaderMapper {
    public static Reader toReader(ReaderRequest readerRequest) {
        return new Reader(readerRequest.getName());
    }
}
