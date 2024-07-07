package com.keeplearning.springboot02mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keeplearning.springboot02mybatis.entity.User2;
import com.keeplearning.springboot02mybatis.mapper.User2Mapper;

@RestController
@RequestMapping("/api/user2")
public class User2Controller {

    @Autowired
    private User2Mapper userMapper;

    @RequestMapping("/getUsers")
    public List<User2> getUsers() {
        List<User2> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User2 getUser(Long id) {
        User2 user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User2 user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User2 user) {
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}