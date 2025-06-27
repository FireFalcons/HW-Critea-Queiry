package com.example.createsearchbook.repository.book.spec;

import com.example.createsearchbook.model.Book;
import com.example.createsearchbook.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    public static final String AUTHOR = "author";
    @Override
    public String getKey() {
        return AUTHOR;
    }

    @Override
    public Specification<Book> getSpecification(String params) {
        return ((root, query, criteriaBuilder) ->
                root.get(AUTHOR).in(params));
    }
}
