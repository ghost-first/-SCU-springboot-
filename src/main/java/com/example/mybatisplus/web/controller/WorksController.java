package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.WorksService;
import com.example.mybatisplus.model.domain.Works;


/**
 *
 *  前端控制器
 *
 *
 * @author drb
 * @since 2021-07-29
 * @version v1.0
 */
@Controller
@RequestMapping("/works")
public class WorksController {

    private final Logger logger = LoggerFactory.getLogger( WorksController.class );

    @Autowired
    private WorksService worksService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Works  works =  worksService.getById(id);
        return JsonResponse.success(works);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        worksService.removeById(id);
        return JsonResponse.success(null);
    }


    @PostMapping(value = "/update")
    @ResponseBody
    public JsonResponse updateWorks(@RequestBody Works  works) throws Exception {
        worksService.saveOrUpdate(works);
        return JsonResponse.success("success");
    }


    /**
    * 描述:创建Works
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Works  works) throws Exception {
        worksService.save(works);
        return JsonResponse.success(null);
    }
}

