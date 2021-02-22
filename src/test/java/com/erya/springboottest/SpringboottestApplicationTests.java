package com.erya.springboottest;

import com.erya.springboottest.entity.Book;
import com.erya.springboottest.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SpringboottestApplicationTests {

    @Autowired
    BookRepository bookRepository;
    @Test
    void contextLoads() {
    }
    @Test
    public void test(){

        Book book = new Book();
        book.setAuthor("张三");
        book.setName("好书");
        Book save = bookRepository.save(book);
        if(save!=null){
            System.out.println("success");
        }else {
            System.out.println("error");
        }
    }
    @Test
    public void findBookById(){
//        Book book = bookRepository.findById(1L).get();
//        System.out.println(book);
        bookRepository.deleteById(1L);
    }

}
