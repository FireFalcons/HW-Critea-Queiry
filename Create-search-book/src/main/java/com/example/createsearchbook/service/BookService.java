package com.example.createsearchbook.service;

import com.example.createsearchbook.dto.BookDto;
import com.example.createsearchbook.dto.BookSearchParametersDto;
import com.example.createsearchbook.mapper.BookMapper;
import com.example.createsearchbook.model.Book;
import com.example.createsearchbook.repository.book.BookRepository;
import com.example.createsearchbook.repository.book.BookSpecificationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    public BookDto save(BookDto bookDto) {
        Book book = bookMapper.toModel(bookDto);
        Book saveBook = bookRepository.save(book);
        return bookMapper.toDto(saveBook);
    }

    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();

    }

    public List<BookDto> search(BookSearchParametersDto params) {
        Specification<Book> bookSpecification = bookSpecificationBuilder.build(params);
        return bookRepository.findAll(bookSpecification).stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
