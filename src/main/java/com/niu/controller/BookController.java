package com.niu.controller;

import com.niu.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ami on 2019/6/15.
 */
@RestController
public class BookController {
    @Resource(name = "jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;

    @Autowired
    @Qualifier("jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;

    @GetMapping("/test1")
    @ResponseBody
    public List<Book> test1() {
        List<Book> books1 = jdbcTemplateOne.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
        List<Book> books2 = jdbcTemplateTwo.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
        System.out.println("books1:" + books1);
        System.out.println("books2:" + books2);
        return books1;
    }

}
