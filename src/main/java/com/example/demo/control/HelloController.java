package com.example.demo.control;

import com.example.demo.utils.StringUtils;
import com.example.demo.utils.StringUtils2;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements EnvironmentAware {

    private Environment environment;

    // 按类型注入
    @Autowired
    StringUtils stringUtils; // field

    @Autowired
    StringUtils2 stringUtils2;

    @Resource
    StringUtils stringUtils3;

    @Value("${person.prefix:nihao}")
    String prefix;

    @GetMapping("/api/sayHello")
    public String say(String name, String age) {
        String department = environment.getProperty("person.department.name", "default");
        System.out.println(department);
        return prefix + name + age;
    }

    @PostMapping("/api/sayHello")
    public String say2(String name, String age, @RequestBody String body) {
        String text = name + " " + age + " " + body;
        return "Hello world, " + text;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
