package com.example.demo.utils;

import org.springframework.stereotype.Component;

@Component // 组件
public class StringUtils {
    public String concat(String str1, String str2){
        return str1 + str2;
    }

}
