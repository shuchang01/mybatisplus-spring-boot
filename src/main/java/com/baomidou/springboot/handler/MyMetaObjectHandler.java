package com.baomidou.springboot.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.baomidou.springboot.MybatisPlusDemoApplication;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  注入公共字段自动填充,任选注入方式即可
 */
//@Component
public class MyMetaObjectHandler extends MetaObjectHandler {
    protected final static Logger logger = LoggerFactory.getLogger(MybatisPlusDemoApplication.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("新增的时候干点不可描述的事情");
        if (metaObject != null) {
//            logger.info("======insertFill====metaObject=====>{}", JSON.toJSONString(metaObject, true));
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("更新的时候干点不可描述的事情");
        if (metaObject != null) {
//            logger.info("===before===updateFill====metaObject=====>{}", JSON.toJSONString(metaObject, true));
        }
        // mybatis-plus版本2.0.9+
        setFieldValByName("simpleDesc", String.valueOf(System.currentTimeMillis()) + "，简单描述信息", metaObject);
//        logger.info("===after===updateFill====metaObject=====>{}", JSON.toJSONString(metaObject, true));
    }
}
