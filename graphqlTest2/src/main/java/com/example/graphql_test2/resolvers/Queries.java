package com.example.graphql_test2.resolvers;

import com.example.graphql_test2.Author;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.com.google.common.collect.ImmutableMap;
import graphql.kickstart.annotations.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@GraphQLQueryResolver
public class Queries {

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

    private static final Logger LOGGER = LoggerFactory.getLogger(Queries.class);

    public Queries() {

    }

    @GraphQLField
    public static List<Author> authors() {
        return authors.stream().map(dataMap -> {
            return new Author(dataMap.get("id"), dataMap.get("firstName"), dataMap.get("lastName"));
        }).collect(Collectors.toList());
    }


}
