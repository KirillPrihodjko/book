package com.example.books.service;

import com.example.books.domain.BookEntity;
import com.example.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void saveBook(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    public List<BookEntity> getAllBooksWithPagination(int numberPage) {
        Pageable pageable = PageRequest.of(numberPage, 50);
        return bookRepository.findAll(pageable).toList();
    }
}
