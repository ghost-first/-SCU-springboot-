package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.LoginUser;
import com.example.mybatisplus.mapper.LoginUserMapper;
import com.example.mybatisplus.service.LoginUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author drb
 * @since 2021-07-27
 */
@Service
public class LoginUserServiceImpl extends ServiceImpl<LoginUserMapper, LoginUser> implements LoginUserService {

    @Autowired
    LoginUserMapper loginUserMapper;

    @Override
    public LoginUser getByPhone(String phoneNumber) {
        LoginUser loginUser = null;
        try {
            loginUser = loginUserMapper.getByPhone(phoneNumber);
        } catch (Exception e) {
            return null;
        }
        return loginUser;
    }
}
