package com.kjipo.graphqlExample;


import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Controller
public class GraphQLTestController {

    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223",
                    "authorId", "author-1"),
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635",
                    "authorId", "author-2"),
            ImmutableMap.of("id", "book-3",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "author-3")
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author-1",
                    "firstName", "Joanne",
                    "lastName", "Rowling"),
            ImmutableMap.of("id", "author-2",
                    "firstName", "Herman",
                    "lastName", "Melville"),
            ImmutableMap.of("id", "author-3",
                    "firstName", "Anne",
                    "lastName", "Rice")
    );

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphQLTestController.class);

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    @QueryMapping
    public Map<String, String> bookById(@Argument String id) {
        return books
                .stream()
                .filter(book -> book.get("id").equals(id))
                .findFirst()
                .orElse(null);
    }


    @QueryMapping
    public Map<String, String> author(@Argument String id) {
        return authors
                .stream()
                .filter(author -> author.get("id").equals(id))
                .findFirst()
                .orElse(null);
    }

}
