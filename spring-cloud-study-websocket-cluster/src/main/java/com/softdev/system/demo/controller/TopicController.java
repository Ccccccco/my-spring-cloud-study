package com.softdev.system.demo.controller;

import com.softdev.system.demo.entity.WsTopic;
import com.softdev.system.demo.repository.WsTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:jichao
 * @date:2020/4/25-22:48
 * @description: 题目控制器
 * Life is so short,do something to make yourself happy,such as coding
 **/
@RestController
public class TopicController {

    @Autowired
    private WsTopicRepository wsTopicRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    @Cacheable(cacheNames = "allTopic")
    @GetMapping(value = "/topic/getAll")
    public List<WsTopic> getAllQuestion(){
        System.out.println("************查询所有题目答案");
        return wsTopicRepository.getAll();
    }

    @Cacheable(cacheNames = "entity",key = "1")
    @GetMapping(value = "/topic/test")
    public WsTopic test(){
        System.out.println("************查询所有题目答案");
        List list = new ArrayList();
        WsTopic wsTopic = new WsTopic();
        wsTopic.setId(1);
        wsTopic.setQuestion("CCC");
        wsTopic.setAnswer("111");
        // redisTemplate.opsForValue().set("123",wsTopic);
        // redisTemplate.opsForValue().set("abc",list);
        return wsTopic;
    }

    @Cacheable(cacheNames = "list",key = "2")
    @GetMapping(value = "/topic/testList")
    public List<WsTopic> testList(){
        System.out.println("************查询所有题目答案");
        List list = new ArrayList();
        WsTopic wsTopic = new WsTopic();
        WsTopic wsTopic2 = new WsTopic();
        WsTopic wsTopic3 = new WsTopic();
        wsTopic.setId(1);
        wsTopic.setQuestion("CCC");
        wsTopic.setAnswer("111");

        wsTopic2.setId(2);
        wsTopic2.setQuestion("DDD");
        wsTopic2.setAnswer("222");

        wsTopic3.setId(3);
        wsTopic3.setQuestion("EEE");
        wsTopic3.setAnswer("333");
        list.add(wsTopic);
        list.add(wsTopic2);
        list.add(wsTopic3);
        // redisTemplate.opsForValue().set("123",wsTopic);
        // redisTemplate.opsForValue().set("abc",list);
        // return wsTopic;
        return list;
    }
}
