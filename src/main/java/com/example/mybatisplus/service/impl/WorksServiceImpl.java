package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Works;
import com.example.mybatisplus.mapper.WorksMapper;
import com.example.mybatisplus.service.WorksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author drb
 * @since 2021-07-29
 */
@Service
public class WorksServiceImpl extends ServiceImpl<WorksMapper, Works> implements WorksService {

}
