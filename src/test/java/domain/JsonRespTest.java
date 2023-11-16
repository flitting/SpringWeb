package domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonRespTest {
    @Test
    void test() throws JsonProcessingException {
        Person person= new Person("xiaoming",18);
        JsonResp<Person> jsonResp = JsonResp.builder(Person.class)
                .ok()
                .message("OK")
                .data(person)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonResp);
        System.out.println(s);
    }

}