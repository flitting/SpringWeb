package com.example.demo.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonRespTest {
    // java 异常捕获
    @Test
    void test() throws JsonProcessingException {
        Person person = new Person("xiaoming", 18);

        // design pattern: builder design pattern
        JsonResp<Person> jsonResp = JsonResp.builder(Person.class) // builder
                .ok() // status = 200
                .message("OK")
                .data(person) // JsonResp.Builder
                .build();


        ObjectMapper objectMapper = new ObjectMapper();
        // ctrl + alt + v
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonResp);
//        String s = objectMapper.writeValueAsString(jsonResp);
        System.out.println(s);


    }

}