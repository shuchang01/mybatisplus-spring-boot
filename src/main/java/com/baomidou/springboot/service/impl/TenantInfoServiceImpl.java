package com.baomidou.springboot.service.impl;

import com.baomidou.springboot.entity.TenantInfo;
import com.baomidou.springboot.mapper.TenantInfoMapper;
import com.baomidou.springboot.service.ITenantInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业（租户）信息表 服务实现类
 * </p>
 *
 * @author Chris
 * @since 2018-02-03
 */
@Service
public class TenantInfoServiceImpl extends ServiceImpl<TenantInfoMapper, TenantInfo> implements ITenantInfoService {

}
