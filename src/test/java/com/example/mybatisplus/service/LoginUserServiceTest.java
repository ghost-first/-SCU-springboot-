package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginUserServiceTest {
    @Autowired
    LoginUserService loginUserService;
    @Autowired
    AdminService adminService;

    @Test
    void getByPhone(){
        LoginUser loginUser = loginUserService.getByPhone("13724522542");
        System.out.println(loginUser.getPassword());
    }

    @Test
    void UserAddPass(){
        LoginUser loginUser = new LoginUser().setPassword("30515").setPhoneNumber("123456");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(loginUser.getPassword()));
        loginUser.setPassword(encoder.encode(loginUser.getPassword()));
        loginUserService.save(loginUser);
    }

    @Test
    void addPass(){
        Admin admin = new Admin().setPassword("30515");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(admin.getPassword()));
        admin.setPassword(encoder.encode(admin.getPassword()));
        adminService.save(admin);
    }

    @Test
    void checkPass(){
        Admin admin = new Admin().setPassword("30515");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String s = encoder.encode(admin.getPassword());
        System.out.println(s);
        System.out.println(encoder.matches("30515",s));
//        admin.setPassword(encoder.encode(admin.getPassword()));
//        adminService.save(admin);
    }

}