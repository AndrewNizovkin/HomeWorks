package ru.geekbrains.homework5.mappers;


import ru.geekbrains.homework5.dto.ReaderRequest;
import ru.geekbrains.homework5.model.Reader;

public class ReaderMapper {
    public static Reader toReader(ReaderRequest readerRequest) {
        return new Reader(readerRequest.getName());
    }
}
