package com.baomidou.springboot.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springboot.entity.Feedback;
import com.baomidou.springboot.entity.vo.FeedbackVO;
import com.baomidou.springboot.service.IFeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Chris
 * @since 2018-02-27
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    @Autowired
    private IFeedbackService feedbackService;

    /**
     * 分页 PAGE
     */
    @GetMapping("/list")
    public Page<Feedback> list() {
        return feedbackService.selectPage(new Page<>(1, 5));
//        return brandService.selectPage(new Page<>(2, 5, "sort_order", false));
    }

    /**
     * 测试mybatis二级缓存，开启二级缓存, application.yml中配置configuration: cache-enabled: true,
     * @param msgId Integer
     * @return FeedbackVO
     */
    @GetMapping("/{msgId}")
    public FeedbackVO getOneFeedback(@PathVariable("msgId") Integer msgId) {
        FeedbackVO vo = new FeedbackVO();
        vo.setMsgId(msgId);
        return feedbackService.queryOneById(vo);
    }

    /**
     * 测试mybatis二级缓存，开启二级缓存, application.yml中配置configuration: cache-enabled: true,
     * @param msgId Integer
     * @return FeedbackVO
     */
    @PostMapping("/{msgId}")
    public void saveOrUpdateOneFeedback(@PathVariable("msgId") Integer msgId) {
        Feedback entity = new Feedback();
        entity.setMsgId(msgId);
        entity.setMsgContent("每当执行insert、update、delete，flushCache=true时，二级缓存都会被清空。真的吗？");
        if (msgId != null) {
            // update
            feedbackService.updateById(entity);
        } else {
            // insert
        }
    }

    /**
     * 测试mybatis二级缓存，开启二级缓存, application.yml中配置configuration: cache-enabled: true,
     * @param msgId Integer
     * @return Feedback
     */
    @GetMapping("/msgId/{msgId}")
    public Feedback getOne(@PathVariable("msgId") Integer msgId) {
        Feedback entity = new Feedback();
        entity.setMsgId(msgId);
        EntityWrapper<Feedback> wrapper = new EntityWrapper<>();
        wrapper.setEntity(entity);
        return feedbackService.selectOne(wrapper);
    }

    /**
     * save or update
     */
    @PostMapping("/saveOrUpdate")
//    public void saveOrUpdate(@RequestBody FeedbackVO feedbackVO) {
    public void saveOrUpdate() {
        FeedbackVO feedbackVO = null;
        if (feedbackVO == null) {
            feedbackVO = new FeedbackVO();
            feedbackVO.setParentId(0);
            feedbackVO.setUserId(1);
            feedbackVO.setUserName("kotori");
            feedbackVO.setUserEmail("feedback-test@gmail.com");
            feedbackVO.setMsgTitle("feedback-test");
            feedbackVO.setMsgType(4);
            feedbackVO.setMsgStatus(0);
            feedbackVO.setMsgContent("hhhhh哈哈哈哈哈");
            feedbackVO.setMsgTime(Integer.valueOf(String.valueOf(1519727)));
            feedbackVO.setMessageImg("/a/b/1234.png");
            feedbackVO.setOrderId(1);
            feedbackVO.setMsgArea(0);
        } else {
            feedbackVO.setUserEmail("测试feedback saveOrUpdate方法====update");
        }
        Feedback entity = new Feedback();
        BeanUtils.copyProperties(feedbackVO, entity);
        boolean result = feedbackService.insertOrUpdate(entity);
        logger.info("=====>/feedback/saveOrUpdate result:{}", result);
        logger.info("=====>ID:{}", entity.getMsgId());

//        feedbackService.insert(entity);
    }
}

