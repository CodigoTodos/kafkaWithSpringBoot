package com.github.brunoalves.producer.model;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Book {
    private String title;
    private Integer pages;

}
