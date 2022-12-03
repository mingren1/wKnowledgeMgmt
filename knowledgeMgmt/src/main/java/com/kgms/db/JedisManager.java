package com.kgms.db;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Objects;

@Component("jedisManager")
public class JedisManager implements InitializingBean, DisposableBean {
    private Logger logger = LoggerFactory.getLogger(JedisManager.class);

    private static final GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
    private static final String host = "192.168.149.128";
    private static int port = 6379;
    private static int timeout = 60000;
    private static final String password = "123";

    private JedisPool jedisPool;
    private Jedis jedis;

    @Override
    public void afterPropertiesSet() throws Exception {
//        jedisPool = new JedisPool(poolConfig, host, port, timeout, password);
        jedisPool = new JedisPool(poolConfig, host);
        jedis = jedisPool.getResource();
        logger.info("redis init success.");
    }

    @Override
    public void destroy() throws Exception {
        if (!Objects.isNull(jedisPool)) {
            jedisPool.close();
            logger.info("jedisPool close success.");
        }
    }

    public Jedis getJedis(){
        return this.jedis;
    }
}
