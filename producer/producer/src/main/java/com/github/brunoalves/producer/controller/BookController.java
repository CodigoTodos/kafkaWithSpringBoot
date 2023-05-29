package com.github.brunoalves.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.brunoalves.producer.model.Book;
import com.github.brunoalves.producer.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public String createBook(@RequestBody Book book) throws JsonProcessingException {
        log.info("create Book request received");
        return bookService.createBook(book);
    }
}
