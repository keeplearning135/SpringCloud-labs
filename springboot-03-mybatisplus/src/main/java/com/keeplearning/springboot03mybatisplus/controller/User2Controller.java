package com.keeplearning.springboot03mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keeplearning.springboot03mybatisplus.entity.User;
import com.keeplearning.springboot03mybatisplus.entity.User2;
import com.keeplearning.springboot03mybatisplus.mapper.User2Mapper;
import com.keeplearning.springboot03mybatisplus.service.UserService;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user2")
public class User2Controller {
    @Autowired
    private User2Mapper userMapper;
    @GetMapping("testInsert")
    public boolean testInsert() {
        User2 user = new User2().setUsername(UUID.randomUUID().toString())
                .setPassword("nicai").setCreateTime(new Date())
                .setDeleted(0); // 一般情况下，是否删除，可以全局枚举下。
        userMapper.insert(user);
        return true;
    }

    @GetMapping("testUpdateById")
    public boolean testUpdateById() {
        User2 updateUser = new User2().setId(1)
                .setPassword("wobucai");
        userMapper.updateById(updateUser);
        return true;
    }

    @GetMapping("testDeleteById")
    public boolean testDeleteById() {
        userMapper.deleteById(2);
        return true;
    }

    @GetMapping("testSelectById")
    public User2 testSelectById() {
        return userMapper.selectById(1);
    }

    @GetMapping("testSelectByUsername")
    public User2 testSelectByUsername() {
        return userMapper.selectByUsername("keeplearning135");
    }

    @GetMapping("testSelectByIds")
    public Collection<User2> testSelectByIds() {
        var users = userMapper.selectByIds(Arrays.asList(1,3,4,6,7,8,9));
        System.out.println("users：" + users.size());
        return users;
    }

    @GetMapping("testSelectPageByCreateTime")
    public IPage<User2> testSelectPageByCreateTime() {
        IPage<User2> page = new Page<>(1, 10);
        Date createTime = new Date(2018 - 1990, Calendar.FEBRUARY, 24); // 临时 Demo ，实际不建议这么写
        page = userMapper.selectPageByCreateTime(page, createTime);
        System.out.println("users：" + page.getRecords().size());
        return page;
    }
}