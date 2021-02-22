package com.erya.springboottest.controller;

import com.erya.springboottest.entity.Book;
import com.erya.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable Integer page, @PathVariable Integer size){

        Pageable pageable = PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);
    }
    @PostMapping("/add")
    public String add(@RequestBody Book book){

        Book save = bookRepository.save(book);
        if(save!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable Long id){

        return bookRepository.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book save = bookRepository.save(book);
        if (save!=null){
            return "success";
        }else{
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        bookRepository.deleteById(id);
    }

}
