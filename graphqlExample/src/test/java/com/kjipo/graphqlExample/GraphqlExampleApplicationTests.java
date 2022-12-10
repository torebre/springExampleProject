package com.kjipo.graphqlExample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.jdbc.Sql;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

//@WebMvcTest(GraphqlController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //, classes = {GraphqlExampleApplication.class, GraphqlController.class}) //(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//    @ComponentScan(basePackages = "com.kjipo.graphqlExample")
class GraphqlExampleApplicationTests {

    @LocalServerPort
    private int port;

//    @Autowired
//    private WebApplicationContext context;
//    private WebGraphQlTester tester;

//    @Autowired
//    private WebTestClient webTestClient;

    @Autowired
    private TestRestTemplate restTemplate;

//    @Autowired
//    private HttpGraphQlTester graphQlTester;


    @Test
    @Sql("/author_test_data.sql")
    void authorQueryWorks() {
//        final var query = "{ \"query\":  \"{ bookById(id: \"book-1\") { name, author { firstName lastName } } }\"";
//        final var query = """
//                {
//                  "query":  "{ bookById(id: \\"book-5\\") { name, author { firstName lastName } } }"
//                }
//                """;
        final var query = """
                {
                "query": "{ authors { id firstName lastName } }" 
                }
                """;


        final var uri = URI.create("http://localhost:" + this.port + "/graphql");
        final var port = 8080;

//        this.restTemplate.getForObject("http://localhost:" + this.port + "/",
//                String.class);

        assertThat(this.restTemplate.getForObject("http://localhost:" + this.port + "/",
                String.class)).contains("Hello, World");

//        final var uri = URI.create("http://localhost:" + port + "/graphql");
//        final var uri = URI.create("http://localhost:" + port + "/");

//        final var response2 = this.restTemplate.getForObject("http://localhost:8080/graphql",
//                String.class);

//        System.out.println("Test50: " + response2);

//        assertThat(this.restTemplate.getForObject("http://localhost:" + 8080 + "/graphql",
//                String.class)).contains("Hello, World");

//        final var response3 = this.restTemplate.postForObject("http://localhost:8080/graphql", null, String.class);

//        System.out.println("Test51: " + response3);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        HttpEntity<String> httpEntity = new HttpEntity<>(query, httpHeaders);
        final var response = this.restTemplate.postForObject("http://localhost:" +this.port +"/graphql", httpEntity, String.class);

//        final var response = this.restTemplate.postForEntity(uri, query, String.class);

        System.out.println("Test30: " + response);

//        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
//        System.out.println("Test23: " +response);
    }


//    @Test
//    void testQuery() {
//        final var uri = URI.create("http://localhost:" + port + "/graphql");
//        final var query = """
//                    query {
//                    bookById(id: "book-2") {
//                        name,
//                        author {
//                            firstName
//                            lastName
//                        }
//                    }
//                }
//                				""";
//
//        this.webTestClient.post()
//                .uri(uri)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Mono.just(query), String.class)
//                .exchange()
//                .expectStatus().isOk();
//
//
//    }


}
