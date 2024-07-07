package com.keeplearning.springboot03mybatisplus.controller;

import com.keeplearning.springboot03mybatisplus.entity.User;
import com.keeplearning.springboot03mybatisplus.mapper.UserMapper;
import com.keeplearning.springboot03mybatisplus.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("list")
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("save")
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }
}