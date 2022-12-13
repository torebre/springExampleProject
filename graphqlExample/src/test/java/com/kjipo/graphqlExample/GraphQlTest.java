package com.kjipo.graphqlExample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.graphql.test.tester.HttpGraphQlTester;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureHttpGraphQlTester
public class GraphQlTest {

    @Autowired
    private HttpGraphQlTester httpGraphQlTester;


    @Test
    public void testQuery() {
        // language=GraphQL
        var query = """
                query { authors { id firstName lastName } }
                """;

        GraphQlTester.Response response = httpGraphQlTester.document(query).execute();

        // TODO

    }

}
