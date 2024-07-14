package com.keeplearning.springboot05redis.controller;

import com.keeplearning.springboot05redis.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.keeplearning.springboot05redis.dataobject.UserDO;

import java.util.Date;
import java.util.UUID;

@RestController
public class UserController {

    private static final String CACHE_NAME_USER = "users";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/testSelectById")
    public UserDO testSelectById() {
        // 这里，胖友事先插入一条 id = 1 的记录。
        Integer id = 1;

        // 查询 id = 1 的记录
        UserDO user = userMapper.selectById(id);
        UserDO user2 = userMapper.selectById0(id);
        UserDO userCache = cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class);
        System.out.println("user：" + user);

        // 查询 id = 1 的记录
        user = userMapper.selectById(id);
        System.out.println("user：" + user);
        return user;
    }

    @RequestMapping("/testInsert")
    public UserDO testInsert() {
        // 插入记录
        UserDO user = new UserDO();
        user.setUsername(UUID.randomUUID().toString()); // 随机账号，因为唯一索引
        user.setPassword("nicai");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        userMapper.insert0(user);

        // 判断缓存中，是不是存在
        UserDO item = cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class);
        return item;
    }


    @RequestMapping("/testDeleteById")
    public UserDO testDeleteById() {
        // 插入记录，为了让缓存里有记录
        UserDO user = new UserDO();
        user.setUsername(UUID.randomUUID().toString()); // 随机账号，因为唯一索引
        user.setPassword("nicai");
        user.setCreateTime(new Date());
        user.setDeleted(0);
        userMapper.insert0(user);
        // 判断缓存中，是不是存在

        // 删除记录，为了让缓存被删除
        userMapper.deleteById(user.getId());
        // 判断缓存中，是不是存在
        UserDO item = cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class);
        return item;
    }
}