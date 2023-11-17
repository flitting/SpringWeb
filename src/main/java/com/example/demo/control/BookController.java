package com.example.demo.control;

import com.example.demo.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

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
}
