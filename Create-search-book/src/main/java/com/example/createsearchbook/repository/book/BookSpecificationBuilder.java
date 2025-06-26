package com.example.createsearchbook.repository.book;

import com.example.createsearchbook.dto.BookSearchParametersDto;
import com.example.createsearchbook.model.Book;
import com.example.createsearchbook.repository.SpecificationBuilder;
import com.example.createsearchbook.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParametersDto) {
        Specification<Book> spec = (
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.conjunction());
        if (searchParametersDto.title() != null && !searchParametersDto.title().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("title")
                    .getSpecification(searchParametersDto.title()));
        }

        if (searchParametersDto.author() != null && !searchParametersDto.author().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("author")
                    .getSpecification(searchParametersDto.author()));
        }

        if (searchParametersDto.isbn() != null && !searchParametersDto.isbn().isEmpty()) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("isbn")
                    .getSpecification(searchParametersDto.isbn()));
        }
        return spec;
    }
}
