package com.kjipo.graphqlExample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DataTest {


    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql("/author_test_data.sql")
    @Sql("/book_test_data.sql")
    public void getAuthorForBook() {
        var book = bookRepository.findById(1L).orElseThrow();
        var author = book.getAuthor();

        assertThat(author.getFirstName(), equalTo("Test"));
        assertThat(author.getLastName(), equalTo("Author"));
    }


}
