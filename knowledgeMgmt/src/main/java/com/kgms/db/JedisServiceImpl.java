package com.kgms.db;

import com.kgms.common.context.ContextUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class JedisServiceImpl {

    private JedisManager jedisManager = (JedisManager)ContextUtils.getBean("jedisManager");

    public void setKey(String key, String value){
        String set = jedisManager.getJedis().set(key, value);
    }

    public String getKey(String key){
        return jedisManager.getJedis().get(key);
    }

    public boolean delKey(String key) {
        Long del = jedisManager.getJedis().del(key);
        if (!Objects.isNull(del)) {
            return true;
        }
        return false;
    }
}
