package com.baomidou.springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.springboot.entity.Feedback;
import com.baomidou.springboot.entity.vo.FeedbackVO;
import com.baomidou.springboot.mapper.FeedbackMapper;
import com.baomidou.springboot.service.IFeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Chris
 * @since 2018-02-27
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements IFeedbackService {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public FeedbackVO queryOneById(FeedbackVO vo) {
        return feedbackMapper.selectOneById(vo);
    }

//    @Transactional(rollbackFor = {ServiceException.class})
    @Transactional
    @Override
    public boolean saveOrInsertOne(Feedback entity) {
        Integer result = null;
            result = feedbackMapper.insert(entity);
            int r = 3 / 0;
        return result == null ? false : true;
    }
}
