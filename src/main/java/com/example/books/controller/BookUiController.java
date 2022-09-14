package com.example.books.controller;

import com.example.books.domain.BookEntity;
import com.example.books.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/ui")
public class BookUiController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public String findPersonById(@ModelAttribute BookEntity book, Model model) {
        log.info("Received find persons by id and dateOfBirth request");
        bookService.saveBook(book);
        model.addAttribute("book", new BookEntity());
        return "addBook";
    }

    @GetMapping("/addBook")
    public String findAllPerson(Model model) {
        log.info("Received find all persons request");
        model.addAttribute("book", new BookEntity());
        return "addBook";
    }
    @GetMapping("/books/{page}")
    public String findAllPerson(Model model, @PathVariable int page) {
        List<BookEntity> books = bookService.getAllBooksWithPagination(page-1);
        log.info("Received find books request");
        model.addAttribute("books", books);
        model.addAttribute("nextPage",Integer.toString(page+1));
        return "books";
    }
}
