package com.keeplearning.springboot03mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.keeplearning.springboot03mybatisplus.entity.User;
import com.keeplearning.springboot03mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
}