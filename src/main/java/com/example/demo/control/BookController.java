package com.example.demo.control;

import com.example.demo.domain.Book;
import com.example.demo.domain.JsonResp;
import com.example.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookMapper bookMapper;

    @GetMapping("/books")
    public ModelAndView booksxxx(){
        ModelAndView mv = new ModelAndView();
        Book book = new Book();
        book.setId(1);
        book.setName("三国演义");
        book.setAuthor("罗贯中");

        Book book2 = new Book(2, "红楼梦", "曹雪芹");

        List<Book> list = new ArrayList<>();
        list.add(book);
        list.add(book2);

        mv.addObject("books", list);
        mv.setViewName("books");
        return mv;
    }

    @PostMapping("/books")
    @ResponseBody
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
}
