package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.domain.Admin;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2021-04-19
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Admin myGetById(Long id);
}
