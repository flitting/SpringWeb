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
    public JsonResp<String> insertBook(String name, String author){
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
    public JsonResp<List<Book>> queryBooks(){
        List<Book> all = bookMapper.findAll();
        return new JsonResp.Builder<List<Book>>()
                .ok()
                .message("OK")
                .data(all)
                .build();
    }

    @GetMapping("/books/page")
    public JsonResp<PageInfo<Book>> queryBooksPaged(int pageNum, int pageSize){
        PageInfo<Object> objectPageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> bookMapper.findAll());
        PageInfo<Book> res = objectPageInfo.convert(item -> (Book) item);
        return new JsonResp.Builder<PageInfo<Book>>()
                .ok()
                .message("OK")
                .data(res)
                .build();
    }


    @DeleteMapping("/books/delete")
    public JsonResp<String> deleteBook(String name){
        List<Book> books = bookMapper.findByName(name);
        if(!books.isEmpty()){
            for(Book book: books){
                bookMapper.deleteById(book.getId());
            }
        }
        return new JsonResp.Builder<String>()
                .ok()
                .message("OK")
                .build();
    }
}
