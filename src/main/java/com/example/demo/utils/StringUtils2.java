package com.example.demo.utils;

import org.springframework.stereotype.Service;

@Service // 服务
public class StringUtils2 {
    public String concat(String str1, String str2){
        return str1 + str2;
    }

}
