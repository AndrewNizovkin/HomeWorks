package ru.geekbrains.homework5.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import ru.geekbrains.homework5.dto.BookDto;
import ru.geekbrains.homework5.model.Book;
import ru.geekbrains.homework5.repository.BookRepository;
import ru.geekbrains.homework5.services.BookService;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class BookControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    void getAllBookIntegrationTest() {
        Book expectedBook = new Book("Диалоги");
        bookRepository.save(expectedBook);

        List<BookDto> actualBooks = bookService.getAll();

        Assertions.assertEquals(1, actualBooks.size());
        Assertions.assertEquals(expectedBook.getId(), actualBooks.get(0).getId());
        Assertions.assertEquals(expectedBook.getName(), actualBooks.get(0).getName());

    }

    @Test
    void getAllBooksWebTest() {
        Book expectedBook = new Book("Диалоги");
        bookRepository.save(expectedBook);

        List<BookDto> responseBody = webTestClient.get()
                .uri("book")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BookDto.class)
//                .expectBody(new ParameterizedTypeReference<List<BookDto>>() {
//                })
                .returnResult()
                .getResponseBody();

        Assertions.assertEquals(1, responseBody.size());
        Assertions.assertEquals(expectedBook.getId(), responseBody.get(0).getId());
        Assertions.assertEquals(expectedBook.getName(), responseBody.get(0).getName());

    }

    @Test
    void getByIdIntegrationTest() {
        Book expectedBook = bookRepository.save(new Book("Стоик"));

        BookDto actualBook = bookService.getById(expectedBook.getId());

        Assertions.assertNotNull(actualBook);
        Assertions.assertEquals(expectedBook.getId(), actualBook.getId());
        Assertions.assertEquals(expectedBook.getName(), actualBook.getName());


    }

    @Test
    void getByIdWebTestSuccess() {
        Book expectedBook = bookRepository.save(new Book("Стоик"));

        BookDto responseBody = webTestClient.get()
                .uri("book/" + expectedBook.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookDto.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertNotNull(responseBody);
        Assertions.assertEquals(expectedBook.getId(), responseBody.getId());
        Assertions.assertEquals(expectedBook.getName(), responseBody.getName());

    }

    @Test
    void getByIdNotFound() {

        bookRepository.saveAll(List.of(
                new Book("Финансист"),
                new Book("Стоик"),
                new Book("Титан")
        ));

        webTestClient.get()
                .uri("book/4")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void removeBookByIdIntegrationTest() {
        Book expectedBook = bookRepository.save(new Book("Крестоносцы"));

        BookDto actualBook = bookService.removeById(expectedBook.getId());

        Assertions.assertNotNull(actualBook);
        Assertions.assertEquals(expectedBook.getId(), actualBook.getId());
        Assertions.assertEquals(expectedBook.getName(), actualBook.getName());
    }

    @Test
    void removeBookByIdWebTest() {

        Book expectedBook = bookRepository.save(new Book("Крестоносцы"));

        BookDto responseBody = webTestClient.delete()
                .uri("book/" + expectedBook.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookDto.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertNotNull(responseBody);
        Assertions.assertEquals(expectedBook.getId(), responseBody.getId());
        Assertions.assertEquals(expectedBook.getName(), responseBody.getName());

    }

    @Test
    void createBookIntegrationTest() {
        BookDto expectedBook = new BookDto("Ревизор");

        BookDto actualBook = bookService.createBook(expectedBook);

        Assertions.assertNotNull(actualBook);
        Assertions.assertEquals(expectedBook.getName(), actualBook.getName());
    }

    @Test
    void createBookWebTest() {
        BookDto expectedBook = new BookDto("Ревизор");

        BookDto responseBody = webTestClient.post()
                .uri("book")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(expectedBook), BookDto.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(BookDto.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertNotNull(responseBody);
        Assertions.assertEquals(expectedBook.getName(), responseBody.getName());
    }
}