package domain;

import com.example.demo.domain.JsonResp;
import com.example.demo.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class JsonRespTest {
    @Test
    void test() throws JsonProcessingException {
        Person person= new Person("xiaoming",18);
        JsonResp<Person> jsonResp = new JsonResp.Builder<Person>()
                .ok()
                .message("OK")
                .data(person)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonResp);
        System.out.println(s);
    }

}