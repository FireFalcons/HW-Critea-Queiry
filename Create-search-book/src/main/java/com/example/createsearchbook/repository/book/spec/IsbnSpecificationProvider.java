package com.example.createsearchbook.repository.book.spec;

import com.example.createsearchbook.model.Book;
import com.example.createsearchbook.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class IsbnSpecificationProvider implements SpecificationProvider<Book> {
    public static final String ISBN = "isbn";
    @Override
    public String getKey() {
        return ISBN;
    }

    @Override
    public Specification<Book> getSpecification(String params) {
        return ((root, query, criteriaBuilder) ->
                root.get(ISBN).in(params));
    }
}
