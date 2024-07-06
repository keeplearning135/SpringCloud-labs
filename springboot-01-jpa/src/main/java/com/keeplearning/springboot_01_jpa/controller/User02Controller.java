package com.keeplearning.springboot_01_jpa.controller;

import com.keeplearning.springboot_01_jpa.entity.Users;
import com.keeplearning.springboot_01_jpa.repository.UserRepository01;
import com.keeplearning.springboot_01_jpa.repository.UserRepository02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user02")
public class User02Controller {

    @Autowired
    private UserRepository02 userRepository;

    @GetMapping("/testFindAll")// 排序
    public Iterable<Users> testFindAll() {
        // 创建排序条件
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        // 执行排序操作
        Iterable<Users> iterable = userRepository.findAll(sort);
        // 打印
        iterable.forEach(System.out::println);
        return iterable;
    }

    @GetMapping("/testFindPage")// 分页
    public Page<Users> testFindPage() {
        // 创建排序条件
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        // 创建分页条件
        Pageable pageable = PageRequest.of(1, 10, sort);
        // 执行分页操作
        Page<Users> page = userRepository.findAll(pageable);
        // 打印
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        return page;
    }
}
