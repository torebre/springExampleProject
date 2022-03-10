package com.kjipo;


import com.kjipo.repository.EventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//@DataJdbcTest
//@AutoConfigureTestDatabase //(replace= AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReactiveWebSocketApplication.class)
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;


    @Test
    public void testEventSave() {
        eventRepository.findById(0);


    }


}
