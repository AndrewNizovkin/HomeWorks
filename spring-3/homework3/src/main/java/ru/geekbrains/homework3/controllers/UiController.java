package ru.geekbrains.homework3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import ru.geekbrains.homework3.services.UiService;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("ui")
@RequiredArgsConstructor
public class UiController {
    private UiService uiService;

    @Autowired
    public UiController(UiService uiService) {
        this.uiService = uiService;
    }

    @GetMapping("books")
    public  String getAllBooks(Model model) {

        model.addAttribute("books", uiService.getAllBook());
        return "books-all";
    }

    @GetMapping("readers")
    public String getAllReaders(Model model) {

        model.addAttribute("readers", uiService.getAllReaders());
        return "readers-all";
    }

    @GetMapping("issues")
    public String getAllIssuesReports(Model model) {
        model.addAttribute("reports", uiService.getIssueReport());
        return "issues-all";
    }

    @GetMapping("reader/{readerId}")
    public String getBooksByReaderId(Model model, @PathVariable long readerId ) {
        try {
            model.addAttribute("reader", uiService.getReaderById(readerId));
            model.addAttribute("books", uiService.getBooksByReaderId(readerId));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return "reader-books";
    }
}
