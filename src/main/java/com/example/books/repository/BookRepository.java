package com.example.books.repository;

import com.example.books.domain.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<BookEntity, Integer> {

    Page<BookEntity> findAll(Pageable pageable);
}
