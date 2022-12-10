package com.kjipo.graphqlExample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/")
    public @ResponseBody String hello() {
        System.out.println("Test80");

        return "Hello, World";
    }

}
