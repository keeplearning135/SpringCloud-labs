package com.keeplearning.springboot01jpa.controller;

import com.keeplearning.springboot01jpa.entity.Users;
import com.keeplearning.springboot01jpa.repository.UserRepository03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/user03")
public class User03Controller {

    @Autowired
    private UserRepository03 userRepository;

    @GetMapping("/testFindByUsername")
    public Users testFindByUsername() {
        Users user = userRepository.findByUsername("yunai");
        System.out.println(user);
        return user;
    }

    @GetMapping("/testFindByCreateTimeAfter")
    public Page<Users> testFindByCreateTimeAfter() {
        // 创建分页条件
        Pageable pageable = PageRequest.of(1, 10);
        // 执行分页操作
        Date createTime = new Date(2018 - 1990, Calendar.FEBRUARY, 24); // 临时 Demo ，实际不建议这么写
        Page<Users> page = userRepository.findByCreateTimeAfter(createTime, pageable);
        // 打印
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        return page;
    }
}
