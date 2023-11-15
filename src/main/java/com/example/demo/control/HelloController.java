package com.example.demo.control;

import com.example.demo.utils.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Resource
    StringUtils stringUtils;

    @GetMapping("/api/sayHello")
    public String say(String name, String age){
        return stringUtils.concat(name,age);
    }

    @PostMapping("/api/sayHello")
    public String say2(String name, String age, @RequestBody String body){
        String text = name +" "+ age +" "+ body;
        return "Hello world, " + text;
    }
}
