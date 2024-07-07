package com.keeplearning.springboot02mybatis.controller;

import com.keeplearning.springboot02mybatis.entity.User;
import com.keeplearning.springboot02mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/testInsert")
    public boolean testInsert() {
        User user = new User().setUsername(UUID.randomUUID().toString())
                .setPassword("nicai").setCreateTime(new Date());
        userMapper.insert(user);
        System.out.println(user.getId());
        return true;
    }

    @RequestMapping("/testUpdateById")
    public boolean testUpdateById() {
        User updateUser = new User().setId(1)
                .setPassword("wobucai");
        userMapper.updateById(updateUser);
        return true;
    }

    @RequestMapping("/testDeleteById")
    public boolean testDeleteById() {
        userMapper.deleteById(2);
        return true;
    }

    @RequestMapping("/testSelectById")
    public User testSelectById() {
        var user = userMapper.selectById(1);
        return user;
    }

    @RequestMapping("/testSelectByUsername")
    public User testSelectByUsername() {
        var user = userMapper.selectByUsername("yunai");
        return user;
    }

    @RequestMapping("/testSelectByIds")
    public List<User> testSelectByIds() {
        List<User> users = userMapper.selectByIds(Arrays.asList(1, 3));
        System.out.println("users：" + users.size());
        return users;
    }
}