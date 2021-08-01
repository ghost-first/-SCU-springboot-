package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.mybatisplus.common.utls.RandomValidateCode;
import com.example.mybatisplus.model.dto.Modify;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.LoginUserService;
import com.example.mybatisplus.model.domain.LoginUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
@RequestMapping("/user")
public class LoginUserController {

    private final Logger logger = LoggerFactory.getLogger( LoginUserController.class );

    @Autowired
    private LoginUserService loginUserService;

    @PostMapping(value = "/check")
    @ApiOperation(value = "用户登录接口")
    @ResponseBody
    public JsonResponse check(@RequestBody LoginUser loginUser) {
        System.out.println(loginUser.getPhoneNumber());
        System.out.println(loginUser.getPassword());
        LoginUser getUser = null;

        getUser = loginUserService.getByPhone(loginUser.getPhoneNumber());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //密码相等
        if (!encoder.matches(loginUser.getPassword(),getUser.getPassword())) {
            return JsonResponse.failure("密码错误").setCode(400);
        }

        return JsonResponse.success(getUser);
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "用户注册接口")
    @ResponseBody
    public JsonResponse register(@RequestBody LoginUser loginUser) {
        if (loginUserService.getByPhone(loginUser.getPhoneNumber()) != null){
            return JsonResponse.failure("该手机号已被注册").setCode(400);
        }

        //对前端发送密码进行加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newPass = encoder.encode(loginUser.getPassword());

        loginUser.setDeleted(true).setPassword(newPass);
        loginUserService.save(loginUser);
        return JsonResponse.success("注册成功");
    }

    @PostMapping(value = "/modify")
    @ApiOperation(value = "修改用户密码")
    @ResponseBody
    public JsonResponse modify(@RequestBody Modify modify) {
        System.out.println("修改密码！！!");
        System.out.println(modify.getPhoneNumber());
        LoginUser findUser = loginUserService.getByPhone(modify.getPhoneNumber());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //原密码如果相等
        if (encoder.matches(modify.getOldPass(),findUser.getPassword())) {
            //将新密码加密
            findUser.setPassword(encoder.encode(modify.getNewPass()));
            loginUserService.saveOrUpdate(findUser);
            System.out.println("密码修改成功！！");
            return JsonResponse.success("密码修改成功！！");
        }

        System.out.println("原密码错误");
        return JsonResponse.failure("原密码错误").setCode(400);
    }

    //登录获取验证码
    @RequestMapping("/getSysManageLoginCode")
    @ResponseBody
    public String getSysManageLoginCode(HttpServletResponse response,
                                        HttpServletRequest request) {
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击
        response.setDateHeader("Expire", 0);
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response,"imagecode");// 输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //验证码验证
    @RequestMapping(value = "/checkimagecode")
    @ResponseBody
    public String checkTcode(HttpServletRequest request, HttpServletResponse response) {
        String validateCode = request.getParameter("validateCode");
        validateCode = validateCode.toUpperCase(); //全部大写

        String code = null;
        //1:获取cookie里面的验证码信息
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("imagecode".equals(cookie.getName())) {
                code = cookie.getValue();
                break;
            }
        }
        //1:获取session验证码的信息
        //String code1 = (String) request.getSession().getAttribute("");
        //2:判断验证码是否正确
        if(!StringUtils.isEmpty(validateCode) && validateCode.equals(code)){
            return "ok";

        }
        return "error";
        //这里我没有进行字母大小模糊的验证处理，感兴趣的你可以去试一下！
    }

}
