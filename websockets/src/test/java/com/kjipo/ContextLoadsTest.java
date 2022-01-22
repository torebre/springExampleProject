package com.kjipo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@DataR2dbcTest
@EnableAutoConfiguration(

        // TODO Figure out why the data source does not get set up during testing
        exclude = {
                R2dbcAutoConfiguration.class,
        }
)
class ContextLoadsTest {

//    @Autowired
//    private EventController eventController;


    @Test
    void contextLoads() {
//        assertThat(eventController).isNotNull();
    }

}
