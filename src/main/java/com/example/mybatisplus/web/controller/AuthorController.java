package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.AuthorService;
import com.example.mybatisplus.model.domain.Author;


/**
 *
 *  前端控制器
 *
 *
 * @author drb
 * @since 2021-07-27
 * @version v1.0
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

    private final Logger logger = LoggerFactory.getLogger( AuthorController.class );

    @Autowired
    private AuthorService authorService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") String sId)throws Exception {
        Integer id = Integer.parseInt(sId);
        Author  author =  authorService.getById(id);
        return JsonResponse.success(author);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @GetMapping("/delete")
    @ResponseBody
    public JsonResponse removeById(@RequestParam(value = "id") Integer id){
        authorService.removeById(id);
        return JsonResponse.success("success");
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @PostMapping(value = "/update")
    @ResponseBody
    public JsonResponse updateAuthor(@RequestBody Author  author) throws Exception {

        System.out.println(author.getId() + "--\n" + author.getWriterType() + "--\n" +
                author.getWriterPhoneNumber());
        authorService.saveOrUpdate(author);
        return JsonResponse.success("success");
    }


    /**
    * 描述:创建Author
    *
    */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody Author author) throws Exception {
        System.out.println("开始创建作者申报表");
        System.out.println(author.getId() + "---" + author.getWriterPhoneNumber() + "---" +
                author.getFormType());
        authorService.save(author);
        return JsonResponse.success(author.getId());
    }

//    @RequestMapping(value = "/list/{id}/{pageNo}/{pageSize}", method = RequestMethod.GET)
//    @ResponseBody
//    public JsonResponse getById(@PathVariable("id") Integer id,@PathVariable("pageNo")  Integer pageNo,
//                                @PathVariable("pageSize")  Integer pageSize )throws Exception {

            //查询列表
    @GetMapping("/list")
    @ResponseBody
    public JsonResponse list(@RequestParam(required = false,defaultValue = "1") Integer pageNo,
                             @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "phoneNumber") String writerPhoneNumber){
        System.out.println("查询启动！！" + writerPhoneNumber);
//        IPage<Author> page = authorService.myQuery(new Page(pageNo,pageSize));
        IPage<Author> page = authorService.mySecQuery(new Page(pageNo,pageSize), writerPhoneNumber);
        return JsonResponse.success(page);
    }

    @GetMapping("/submit")
    @ResponseBody
    public JsonResponse submit(@RequestParam(value = "id") Integer id){
        System.out.println("提交表！！");
        Author author = authorService.getById(id);
        author.setCommitState(1);
        authorService.saveOrUpdate(author);
        return JsonResponse.success("success");
    }
}

