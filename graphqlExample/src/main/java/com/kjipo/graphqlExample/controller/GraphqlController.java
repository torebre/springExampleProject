package com.kjipo.graphqlExample.controller;


import com.google.common.collect.ImmutableMap;
import com.kjipo.graphqlExample.Author;
import com.kjipo.graphqlExample.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;


@Controller
public class GraphqlController {

    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223",
                    "authorId", "1"),
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635",
                    "authorId", "2"),
            ImmutableMap.of("id", "book-3",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "3")
    );

    private final AuthorRepository authorRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphqlController.class);

    public GraphqlController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }



    @QueryMapping
    public Map<String, String> bookById(@Argument String id) {
        return books
                .stream()
                .filter(book -> book.get("id").equals(id))
                .findFirst()
                .orElse(null);
    }


    @QueryMapping
    public Map<String, String> authorById(@Argument String id) {
        var author = authorRepository.findById(Long.valueOf(id));

        return author.map(temp ->
                Map.of("firstName", temp.getFirstName())).orElse(Collections.emptyMap());

//        return authors
//                .stream()
//                .filter(author -> author.get("id").equals(id))
//                .findFirst()
//                .orElse(null);
    }

    @QueryMapping
    public List<Author> authors() {
        final var temp = StreamSupport.stream(authorRepository.findAll().spliterator(), false).toList();
        return temp;
    }

    @MutationMapping
    public String deleteAuthor(@Argument String author) {
        // TODO
        return "";
    }

}
