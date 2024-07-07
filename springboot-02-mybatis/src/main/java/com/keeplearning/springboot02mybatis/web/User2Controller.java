package com.keeplearning.springboot02mybatis.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keeplearning.springboot02mybatis.entity.Users2;
import com.keeplearning.springboot02mybatis.mapper.User2Mapper;

@RestController
public class User2Controller {

    @Autowired
    private User2Mapper userMapper;

    @RequestMapping("/getUsers")
    public List<Users2> getUsers() {
        List<Users2> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public Users2 getUser(Long id) {
        Users2 user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(Users2 user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(Users2 user) {
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }


}