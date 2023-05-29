package com.github.brunoalves.consumer.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.brunoalves.consumer.dto.BookDto;
import com.github.brunoalves.consumer.model.Book;
import com.github.brunoalves.consumer.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private static final String ORDERTOPIC = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final BookService bookService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, BookService bookService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.bookService = bookService;
    }

    @KafkaListener(topics = ORDERTOPIC)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        BookDto bookDto = objectMapper.readValue(message, BookDto.class);
        Book book = modelMapper.map(bookDto, Book.class);
        bookService.persistBook(book);
    }
}
