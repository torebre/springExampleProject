package com.kjipo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;


@DataJdbcTest
@AutoConfigureTestDatabase //(replace= AutoConfigureTestDatabase.Replace.NONE)
//@RunWith(SpringRunner.class)
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;


    @Test
    public void testEventSave() {

        eventRepository.findById(0);


    }


}
