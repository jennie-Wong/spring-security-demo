package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisUtil {

    @Autowired
    private StringRedisTemplate template;


    /**
     * 设置redis的值不设置过期时间
     * @param key
     * @param value
     */
    public  void setKeyForever(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value);
    }

    /**
     * 将某个值保存在redis当中,设置过期时间
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    public  void setKeyTimes(String key,String value,long timeout,TimeUnit unit){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value,timeout,unit);
    }

    /**
     * 根据key获取该key的value值
     * @param key
     * @return
     */
    public String getValue(String key){
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }

    //查看某个key的值redis中存不存在
    public boolean hasKey(String key){
        return template.hasKey(key);
    }

    //删除某个key的值
    public void deleteKey(String key){
        template.delete(key);
    }

    //设置List类型的值，先进后出
    public void setlPushtList(String key, List<Object> value) {
        ListOperations listOperations = template.opsForList();
        listOperations.leftPushAll(key, value);
    }

    //设置List类型的值，先进先出
    public void setrPushtList(String key, List<Object> value){
        ListOperations listOperations = template.opsForList();
        listOperations.rightPushAll(key,value);
    }

    //获取List类型的值，先进后出
    public Object getlList(String key) {
        return template.opsForList().leftPop(key);
    }

    //获取List类型的值，先进先出
    public Object getrList(String key) {
        return template.opsForList().rightPop(key);
    }

    //设置Set类型的值
    public void setSet(String key, Object... objects) {
        SetOperations setOperations = template.opsForSet();
        setOperations.add(key,objects);
    }

    //根据key值获取set类型的值
    public Object getSet(String key) {
        return template.opsForSet().members(key);
    }

    //设置Hash类型的值
    public void setHash(String key, Map<String, Object> value) {
        HashOperations hashOperations = template.opsForHash();
        hashOperations.putAll(key, value);
    }

    public boolean hasHashKey(String key,String hashKey){
        return template.opsForHash().hasKey(key,hashKey);
    }


    //根据key值返回Hash类型的值
    public Object getHash(String key) {
        return template.opsForHash().entries(key);
    }

    //根据key值删除某个Hash类型数据下的某个key
    public void deleteHashKey(String key,String hashKey){
        template.opsForHash().delete(key,hashKey);
    }

    public Long incr(String key, long liveTime) {
//        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, template.getConnectionFactory());
//        Long increment = entityIdCounter.getAndIncrement();
//        System.out.println("increment--2----"+template);
//        System.out.println("increment--1----"+template.opsForValue());
//        System.out.println("increment---2----"+increment);
        Long increment1 = template.opsForValue().increment(key, liveTime);
//        System.out.println("increment1-------"+increment1);
//        if ((null == increment || increment.longValue() == 0) && liveTime > 0) {//初始设置过期时间
//            entityIdCounter.expire(liveTime, TimeUnit.SECONDS);
//        }

        return increment1;
    }

//    public static void main(String[] args) {
//        RedisMapper redisMapper = new RedisMapper();
//        System.out.println("number----------"+redisMapper.incr("number",0));
//    }
}
