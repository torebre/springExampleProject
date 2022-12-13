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


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        HttpEntity<String> httpEntity = new HttpEntity<>(query, httpHeaders);
        final var response = this.restTemplate.postForObject("http://localhost:" + this.port + "/graphql", httpEntity, String.class);

        // TODO
        System.out.println("Test30: " + response);

    }

}
