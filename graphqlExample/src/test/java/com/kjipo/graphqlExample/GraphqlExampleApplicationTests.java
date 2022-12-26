package com.kjipo.graphqlExample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GraphqlExampleApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Sql("/author_test_data.sql")
    void authorQueryWorks() {
        final var query = """
                {
                "query": "{ authors { id firstName lastName } }" 
                }
                """;


        final var response = runQuery(query);

        // TODO
        System.out.println("Test30: " + response);

    }

    @Test
    @Sql("/author_test_data.sql")
    @Sql("/book_test_data.sql")
    void bookQueryWorks() {
        final var query = """
                {
                "query": "{ books { id title } }"
                }
                """;

        final var response = runQuery(query);

        // TODO
        System.out.println("Test31: " + response);

    }

    private String runQuery(String query) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        HttpEntity<String> httpEntity = new HttpEntity<>(query, httpHeaders);
        return this.restTemplate.postForObject("http://localhost:" + this.port + "/graphql", httpEntity, String.class);
    }
}
