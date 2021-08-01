package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.common.utls.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.FilePathService;
import com.example.mybatisplus.model.domain.FilePath;
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
@RequestMapping("/file")
public class FilePathController {

    private final Logger logger = LoggerFactory.getLogger( FilePathController.class );

    @Autowired
    private FilePathService filePathService;

    // 传入的参数file是我们指定的文件
    @RequestMapping("/upload")
    @ResponseBody
    public JsonResponse upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id,@RequestParam("phoneNumber") String phoneNumber) {
        System.out.println("存储文件的函数启动了！！");
        FilePath filePath = new FilePath().setFormId(id).setPhoneNumber(phoneNumber);
//            System.out.println(filePathService.upload(file));
        filePath.setPath(FileUtil.upload(file,"resource/"));
        filePathService.saveOrUpdate(filePath);
        return JsonResponse.success("success");
    }
}

