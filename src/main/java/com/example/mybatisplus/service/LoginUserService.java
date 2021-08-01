package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.LoginUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author drb
 * @since 2021-07-27
 */
public interface LoginUserService extends IService<LoginUser> {

    LoginUser getByPhone(String phoneNumber);
}
