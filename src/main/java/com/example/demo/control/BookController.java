package com.example.demo.control;

import domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/books")
    public ModelAndView books(){
        ModelAndView mv = new ModelAndView();
        Book book = new Book(1,"三国演义","罗贯中");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        mv.addObject("books",bookList);
        mv.setViewName("books");
        return mv;
    }

}
