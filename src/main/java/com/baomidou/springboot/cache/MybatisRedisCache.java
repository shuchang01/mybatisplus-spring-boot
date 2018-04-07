package com.baomidou.springboot.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 基于 @CacheNamespace mapper接口 声明式注解方式的cache实现
 *
 * @author Chris
 * @since April 3, 2018
 */
public class MybatisRedisCache implements Cache {
    private static final Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);

    private static final String REDIS_HOST = "127.0.0.1";
    private static final int REDIS_PORT = 16379;

    
    private Jedis redisClient = createRedis();

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.info("==============>>>MybatisRedisCache:id={}", id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getSize() {
        int dbsize = Integer.valueOf(redisClient.dbSize().toString());
        logger.info("==============>>>redis dbsize={}", dbsize);
        return dbsize;
    }

    @Override
    public void putObject(Object key, Object value) {
        logger.info("==============>>>putObject=====key={}, value={}", key, value);
        redisClient.set(SerializationUtils.serialize(key.toString()), SerializationUtils.serialize(value));

    }

    @Override
    public Object getObject(Object key) {
        Object value = SerializationUtils.deserialize(redisClient.get(SerializationUtils.serialize(key.toString())));
        logger.info("==============>>>getObject=====key={}, value={}", key, value);
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        return redisClient.expire(SerializationUtils.serialize(key.toString()), 0);
    }

    @Override
    public void clear() {
        redisClient.flushDB();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }


    @SuppressWarnings("resource")
	protected static Jedis createRedis() {
        JedisPool pool = new JedisPool(REDIS_HOST, REDIS_PORT);
        return pool.getResource();
    }
}
