package com.baomidou.springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.springboot.entity.Brand;
import com.baomidou.springboot.mapper.BrandMapper;
import com.baomidou.springboot.service.IBrandService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author K神带你飞
 * @since 2018-02-02
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

}
