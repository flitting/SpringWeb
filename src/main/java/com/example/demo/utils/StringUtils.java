package com.example.demo.utils;

public class StringUtils {
    String name;
    public StringUtils(){

    }
    public StringUtils(String name){
        this.name = name;

    }
    public String concat(String str1, String str2){
        return str1 + str2;
    }

    public String getName() {
        return name;
    }
}
