package com.example.demo.mapper;

import com.example.demo.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    int insert(Book book);

    List<Book> findAll();

    List<Book> findByName(String name);

    int deleteById(int id);
}
