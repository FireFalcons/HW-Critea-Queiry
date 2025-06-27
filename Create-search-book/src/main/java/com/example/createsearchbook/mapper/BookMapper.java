package com.example.createsearchbook.mapper;

import com.example.createsearchbook.dto.BookDto;
import com.example.createsearchbook.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(BookDto bookDto);
}
