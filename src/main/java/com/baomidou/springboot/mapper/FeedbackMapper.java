package com.baomidou.springboot.mapper;

import com.baomidou.springboot.entity.Feedback;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.springboot.entity.vo.FeedbackVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Chris
 * @since 2018-02-27
 */
public interface FeedbackMapper extends BaseMapper<Feedback> {
    /**
     * 测试自定义 sql-ID 查询
     * @param vo FeedbackVO
     * @return FeedbackVO
     */
    FeedbackVO selectOneById(FeedbackVO vo);
}
