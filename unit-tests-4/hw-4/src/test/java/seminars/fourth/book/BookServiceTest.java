package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Iterator;
import java.util.List;

public class BookServiceTest {

    @Test
    public void returnBookById() {
        Book book = new Book("1");
        BookRepository repository = mock(BookRepository.class);
        when(repository.findById("1")).thenReturn(book);

        BookService bookService = new BookService(repository);
        Book result = bookService.findBookById("1");

        assertTrue(book == result);
    }

    @Test
    public void getAllBooks() {
        BookRepository repository = mock(BookRepository.class);
        when(repository.findAll()).thenReturn(null);

        BookService bookService = new BookService(repository);
        List<Book> result = bookService.findAllBooks();

        assertTrue(result == null);

    }

    @Test
    public void checkCallsFindAllBooks() {
        BookRepository repository = mock(BookRepository.class);
        when(repository.findAll()).thenReturn(null);

        BookService bookService = new BookService(repository);
        List<Book> result = bookService.findAllBooks();
        result = bookService.findAllBooks();
        result = bookService.findAllBooks();

        verify(repository, times(3)).findAll();

    }
}
