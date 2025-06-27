package com.example.createsearchbook.controller;

import com.example.createsearchbook.dto.BookDto;
import com.example.createsearchbook.dto.BookSearchParametersDto;
import com.example.createsearchbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto);
    }

    @GetMapping
    public List<BookDto> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/search")
    public List<BookDto> search(BookSearchParametersDto searchParametersDto) {
        return bookService.search(searchParametersDto);
    }
}
