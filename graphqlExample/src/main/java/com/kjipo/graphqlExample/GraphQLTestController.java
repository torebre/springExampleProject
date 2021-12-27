package com.kjipo.graphqlExample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLTestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphQLTestController.class);

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    public String bookById(@Argument Long id) {
        return GraphQLDataFetchers.books
                .stream()
                .filter(book -> book.get("id").equals(id))
                .findFirst()
                .orElse(null)
                .get("name");

    }

}
