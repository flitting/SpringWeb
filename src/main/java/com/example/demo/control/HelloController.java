package com.example.demo.control;

import com.example.demo.utils.StringUtils;
import com.example.demo.utils.StringUtils2;
import jakarta.annotation.Resource;
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

    @Autowired
    StringUtils2 stringUtils2;

    @Resource
    StringUtils stringUtils3;

    @GetMapping("/api/sayHello")
    public String say(String name, String age) {
//        return stringUtils.concat(name, "" + age);
//        return stringUtils2.concat(name, ""+age);
        return stringUtils3.concat(name, ""+age);
    }

    @PostMapping("/api/sayHello")
    public String say2(String name, String age, @RequestBody String body) {
        String text = name + " " + age + " " + body;
        return "Hello world, " + text;
    }
}
