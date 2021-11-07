package com.kjipo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EventController {

    @GetMapping("/event")
    public String test() {
        return "testEvent";
    }

}
