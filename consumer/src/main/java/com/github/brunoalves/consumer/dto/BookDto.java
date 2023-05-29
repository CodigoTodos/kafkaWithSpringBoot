package com.github.brunoalves.consumer.dto;

import lombok.Data;
import lombok.Value;
@Data
@Value
public class BookDto {
    private String title;
    private Integer pages;
}
