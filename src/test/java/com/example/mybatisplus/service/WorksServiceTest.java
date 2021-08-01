package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Works;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorksServiceTest {
    @Autowired
    WorksService worksService;

    @Test
    void save(){
        Works work = new Works().setId(5).setPlatform("ahdskjfshekfukhje");
        worksService.saveOrUpdate(work);
    }
}