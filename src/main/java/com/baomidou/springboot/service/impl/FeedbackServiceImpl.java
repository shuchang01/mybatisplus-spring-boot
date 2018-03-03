package com.baomidou.springboot.service.impl;

import com.baomidou.springboot.entity.Feedback;
import com.baomidou.springboot.entity.vo.FeedbackVO;
import com.baomidou.springboot.mapper.FeedbackMapper;
import com.baomidou.springboot.service.IFeedbackService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chris
 * @since 2018-02-27
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public FeedbackVO queryOneById(FeedbackVO vo) {
        return feedbackMapper.selectOneById(vo);
    }
}
