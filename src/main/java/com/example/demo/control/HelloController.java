package com.example.demo.control;

import com.example.demo.utils.StringUtils;
import domain.JsonResp;
import domain.Person;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements EnvironmentAware {
    private Environment environment;
    @Resource
    StringUtils stringUtils;

    @Value("${person.prefix:Hi}")
    String prefix;
    @GetMapping("/api/sayHello")
    public JsonResp<Person> say(String name, int age){
        Person person = new Person(name,age);
        JsonResp<Person> result = JsonResp.builder(Person.class)
                .ok()
                .message("OK")
                .data(person)
                .build();
        return result;
    }

    @PostMapping("/api/sayHello")
    public String say2(String name, String age, @RequestBody String body){
        String text = name +" "+ age +" "+ body;
        return "Hello world, " + text;
    }

    @Override
    public void setEnvironment(Environment environment){
        this.environment = environment;
    }

}
