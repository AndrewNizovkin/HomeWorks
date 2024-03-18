package ru.geekbrains.homework3.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.homework3.models.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        getDemoBooks();
    }

    /**
     * Gets copy of book list
     * @return
     */
    public List<Book> getAll() {
        return List.copyOf(books);
    }

    /**
     * Adds book to books
     * @param book
     * @return
     */
    public boolean addBook(Book book) {
        return books.add(book);
    }

    /**
     * Gets book from book list by id
     * @param id
     * @return
     */
    public Book getById(long id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Removes book from books by id
     * @param id
     * @return
     */
    public boolean removeById( long id) {
        return books.removeIf(book -> book.getId() == id);
    }

    /**
     * Gets demo book list
     */
    private void getDemoBooks() {
        books.add(new Book("Война и мир"));
        books.add(new Book("Мастер и Маргарита"));
        books.add(new Book("Приключения Буратино"));
        books.add(new Book("Декамерон"));
        books.add(new Book("Преступление и наказание"));
    }
}
