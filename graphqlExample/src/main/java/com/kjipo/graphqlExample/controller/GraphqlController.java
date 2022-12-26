package com.kjipo.graphqlExample.controller;


import com.kjipo.graphqlExample.Author;
import com.kjipo.graphqlExample.AuthorRepository;
import com.kjipo.graphqlExample.Book;
import com.kjipo.graphqlExample.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;


@Controller
public class GraphqlController {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;


    public GraphqlController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @QueryMapping
    public Map<String, String> bookById(@Argument long id) {
        return bookRepository.findById(id).map(book -> Map.of("title", book.getTitle(),
                        "pageCount", String.valueOf(book.getPageCount())))
                .orElse(Collections.emptyMap());
    }


    @QueryMapping
    public Map<String, String> authorById(@Argument String id) {
        return authorRepository.findById(Long.valueOf(id)).map(temp ->
                Map.of("firstName", temp.getFirstName())).orElse(Collections.emptyMap());
    }

    @QueryMapping
    public List<Author> authors() {
        return StreamSupport.stream(authorRepository.findAll().spliterator(), false).toList();
    }

    @QueryMapping
    public List<Book> books() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false).toList();
    }

    @MutationMapping
    public String deleteAuthor(@Argument String author) {
        // TODO
        return "";
    }

}
