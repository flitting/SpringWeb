package com.example.demo.control;

import com.example.demo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 按类型注入
    @Autowired
    StringUtils stringUtils; // field

    @GetMapping("/api/sayHello")
    public String say(String name, String age) {
        System.out.println(stringUtils.getName());
        return stringUtils.concat(name, "" + age);
    }

    @PostMapping("/api/sayHello")
    public String say2(String name, String age, @RequestBody String body) {
        String text = name + " " + age + " " + body;
        return "Hello world, " + text;
    }
}
