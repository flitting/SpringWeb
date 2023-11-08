package com.example.demo.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/sayHello")
    public String say(String name, String age){
        String text = name +" "+ age;
        return "Hello world, "+ text;
    }

    @PostMapping("/api/sayHello")
    public String say2(String name, String age, @RequestBody String body){
        String text = name +" "+ age +" "+ body;
        return "Hello world, " + text;
    }
}
