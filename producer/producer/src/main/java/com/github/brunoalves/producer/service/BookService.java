package com.github.brunoalves.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.brunoalves.producer.model.Book;
import com.github.brunoalves.producer.service.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookService {

    private final Producer producer;

    @Autowired
    public BookService(Producer producer) {
        this.producer = producer;
    }

    public String createBook(Book book) throws JsonProcessingException {
        return producer.sendMessage(book);
    }

}
