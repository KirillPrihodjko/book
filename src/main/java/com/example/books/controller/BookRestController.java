package com.example.books.controller;

import com.example.books.domain.BookEntity;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{page}")
    public List<BookEntity> findAllPerson(@PathVariable int page) {
        return bookService.getAllBooksWithPagination(page - 1);
    }
}
