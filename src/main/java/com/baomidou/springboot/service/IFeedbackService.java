package com.baomidou.springboot.service;

import com.baomidou.springboot.entity.Feedback;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.springboot.entity.vo.FeedbackVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Chris
 * @since 2018-02-27
 */
public interface IFeedbackService extends IService<Feedback> {
    FeedbackVO queryOneById(FeedbackVO vo);
}
