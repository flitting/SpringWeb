package com.example.demo.control;

import com.example.demo.domain.Book;
import com.example.demo.domain.JsonResp;
import com.example.demo.mapper.BookMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookMapper bookMapper;

    @PostMapping("/books/add")
    public JsonResp<String> insertBook(String name, String author) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        bookMapper.insert(book);
        return new JsonResp.Builder<String>()
                .ok()
                .message("OK")
                .build();

    }

    @GetMapping("/books")
    public JsonResp<List<Book>> queryBooks() {
        List<Book> allBooks = bookMapper.findAll();
        return new JsonResp.Builder<List<Book>>()
                .ok()
                .message("OK")
                .data(allBooks)
                .build();
    }
    @GetMapping("/books/page")
    public JsonResp<PageInfo<Book>> queryBookPaged(int pageNum, int pageSize){
        PageInfo<Object> objects = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> bookMapper.findAll());
        PageInfo<Book> result = objects.convert(item -> (Book)item);
        return new JsonResp.Builder<PageInfo<Book>>()
                .ok()
                .message("OK")
                .data(result)
                .build();
    }

    @DeleteMapping("/books/delete")
    public JsonResp<String> deleteBooks(String name) {
        List<Book> deleteBooks = bookMapper.findByName(name);
        for(Book book:deleteBooks){
            bookMapper.deleteById(book.getId());
        }
        return new JsonResp.Builder<String>()
                .ok()
                .message("OK")
                .build();
    }

}
