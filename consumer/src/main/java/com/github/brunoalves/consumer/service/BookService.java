package com.github.brunoalves.consumer.service;

import com.github.brunoalves.consumer.model.Book;
import com.github.brunoalves.consumer.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void persistBook(Book book) {
        Book persistedBook = bookRepository.save(book);
        log.info("Book persisted {}", persistedBook);
    }
}
