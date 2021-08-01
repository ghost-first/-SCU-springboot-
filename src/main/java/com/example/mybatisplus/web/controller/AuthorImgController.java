package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.common.utls.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.AuthorImgService;
import com.example.mybatisplus.model.domain.AuthorImg;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 *  前端控制器
 *
 *
 * @author drb
 * @since 2021-07-28
 * @version v1.0
 */
@Controller
@RequestMapping("/authorImg")
public class AuthorImgController {

    private final Logger logger = LoggerFactory.getLogger( AuthorImgController.class );

    @Autowired
    private AuthorImgService authorImgService;

    // 传入的参数file是我们指定的文件
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id) {
        System.out.println("函数启动了！！");
        // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
        AuthorImg authorImg = new AuthorImg().setFormId(id);

        authorImg.setImgPath(FileUtil.upload(file,"authorImg/"));
        authorImgService.saveOrUpdate(authorImg);
        return "success";
    }
}

