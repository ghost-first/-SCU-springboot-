package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    AuthorService authorService;


    @Test
    void myQuery(){
        Integer pageNo = 1;
        Integer pageSize = 10;
        IPage<Author> page = authorService.myQuery(new Page(pageNo,pageSize));
    }

    @Test
    void mySecQuery(){
        Integer pageNo = 1;
        Integer pageSize = 10;
        String writerPhoneNumber = "13769134685";
        IPage<Author> page = authorService.mySecQuery(new Page(pageNo,pageSize),writerPhoneNumber);
    }

    @Test
    void del(){
        authorService.removeById("52");
    }


}