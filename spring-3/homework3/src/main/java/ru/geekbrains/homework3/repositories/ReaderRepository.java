package ru.geekbrains.homework3.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.homework3.models.Book;
import ru.geekbrains.homework3.models.Reader;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReaderRepository {
    private List<Reader> readers;

    public ReaderRepository() {
        readers = new ArrayList<>();
        getDemoReaders();
    }

    /**
     * Gets all readers
     * @return List of Reader instance
     */
    public List<Reader> getAll() {
        return List.copyOf(readers);
    }

    /**
     * Get reader from reader list by id
     * @param id
     * @return
     */
    public Reader getById(long id) {
        return readers.stream()
                .filter(reader -> reader.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Removes reader from readers by id
     * @param id
     * @return
     */
    public boolean removeById( long id) {
        return readers.removeIf(reader -> reader.getId() == id);
    }

    /**
     * Adds reader to readers
     * @param reader
     * @return
     */
    public boolean addReader(Reader reader) {
        return readers.add(reader);
    }



    /**
     * Gets demo reader list
     */
    private void getDemoReaders() {
        readers.add(new Reader("Костя"));
        readers.add(new Reader("Василий"));
        readers.add(new Reader("Семён"));
        readers.add(new Reader("Андрей"));
    }
}
