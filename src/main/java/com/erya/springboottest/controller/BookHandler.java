package com.erya.springboottest.controller;

import com.erya.springboottest.entity.Book;
import com.erya.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/findAll")
    public List<Book> findAll(){

        return bookRepository.findAll();
    }

}
