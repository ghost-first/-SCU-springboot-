package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.mapper.LoginUserMapper;
import com.example.mybatisplus.model.domain.LoginUser;
import com.example.mybatisplus.service.LoginUserService;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
//
//@SpringBootTest
//class MybatisplusApplicationTests {
//
//    @Autowired
//    private LoginUserService loginUserService;
//
//    @Autowired
//    private LoginUserMapper  loginUserMapper;
//    @Test
//    public void updateLoginUser(@RequestBody LoginUser loginUser) throws Exception {
//        List<LoginUser> loginUsers = new ArrayList<>();
//        LoginUser user =new LoginUser().setName("小明").setPassword("321");
//       // loginUserService.save(user);
//        loginUserMapper.insert(user);
//        System.out.println("成功！");
////        BaseMapper<LoginUser> loginUserService= null;
////        loginUserService.updateById(user);
////        return JsonResponse.success("修改成功!");
//    }
//}
//
////    @Autowired
////    private AdminService adminService;
////    @Test
////    void contextLoads() {
////        Admin byId = adminService.getById(1);
////        System.out.println(byId);
////    }
//
//    @Autowired
//    private BookService bookService;
//    @Autowired
//    private BookMapper bookMapper;
//    @Test
//    void saveBook(){
////        Book book = new Book().setName("红楼").setAuthor("佚名").setPrice(88.8);
//        Book book = new Book().setName("三国").setAuthor("罗贯中").setPrice(99.8).setId(1L);
////        bookService.saveOrUpdate(book);
//        bookService.save(book);
////        bookMapper.insert(book);
//    }
//
//    @Test
//    void saveManyBook(){
//        List<Book> books = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            books.add(new Book().setName("水浒"+i).setAuthor("施耐庵"+i).setPrice(2.8*i));
//        }
//        bookService.saveBatch(books);
//    }
//
//    @Test
//    void saveManyBook2(){
//        List<Book> books = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            books.add(new Book().setName("水浒"+i).setAuthor("施耐庵"+i).setId(200L+i));
//        }
//        bookService.mySaveBatch(books);
//    }
//
//    @Test
//    void saveManyBook3(){
//        List<Long> longs = Arrays.asList(2L, 3L, 4L);
//        //删除 delete from book id in (2,3,4)
//        List<Book> books = new ArrayList<>();
//
//    }
//
//    @Test
//    void queryBook(){
//        //查询名字带有3的图书 或 id为3
//        // where like "%3%"
//        //条件构造器
//        QueryWrapper<Book> wrapper = new QueryWrapper<>();
//        wrapper.like("name","3").or()
//        .eq("id",3);
//        List<Book> list = bookService.list(wrapper);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getName());
//        }
//
//    }
//
////    分页
//    @Test
//    void pageQuery(){
//        //无条件分页查询
//        Integer pageNo = 11;
//        Integer pageSize = 10;
//
//        Page<Book> page = bookService.page(new Page<>(pageNo, pageSize));
//        List<Book> records = page.getRecords();
//        //后面加wrapper，先条件，后分页
//    }
//
//    @Test
//    void myQuery(){
//        //自己写查询id为3
//        Book book = bookService.mySelectById(3);
//    }
//
//    @Test
//    void hh6(){
//        Book book = new Book().setAuthor("佚名").setName("三国");
//        List<Book> books = bookService.mySelectByBook(book);
//    }
//
//    @Test
//    void myPage(){
//        Integer pageNo = 1;
//        Integer pageSize = 10;
//        Book book = new Book().setName("水浒").setAuthor("施耐庵");
//        IPage<Book> page = bookService.myPage(new Page(pageNo,pageSize),book);
//    }
//
//    @Test
//    void hh(){
//        //lang3 判断是否为null 或 ‘’
//        if(StringUtils.isBlank("")){
//
//        }
//        Book book = null;
//        if(Objects.isNull(book)){
//
//        }
//    }
//
//    @Test
//    void hh9(){
//        Book byId = bookService.getById(102);
//        System.out.println(byId);
//    }
//
//    @Test
//    void hh10(){
//        bookService.removeById(101);
//    }
//
//}
