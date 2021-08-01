package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.mapper.AdminMapper;
import com.example.mybatisplus.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-04-19
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin myGetById(Long id) {
        return adminMapper.myGetById(id);
    }
}
