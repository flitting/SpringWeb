package com.example.demo.mapper;

import com.example.demo.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

    int insert(Book book);
}
