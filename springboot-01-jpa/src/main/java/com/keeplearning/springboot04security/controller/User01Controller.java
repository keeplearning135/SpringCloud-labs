package com.keeplearning.springboot04security.controller;

import com.keeplearning.springboot04security.entity.Users;
import com.keeplearning.springboot04security.repository.UserRepository01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user01")
public class User01Controller {

    @Autowired
    private UserRepository01 userRepository;

    @GetMapping("/testSave")
    public Users testSave() {
       Users user = new Users().setUsername(UUID.randomUUID().toString())
                .setPassword("guess").setCreateTime(new Date());
       var item = userRepository.save(user);
       return item;
    }

    @GetMapping("/testUpdate")
    public Users testUpdate() {
        // 先查询一条记录
        Optional<Users> Users = userRepository.findById(1);
        Assert.isTrue(Users.isPresent(), "记录不能为空");
        // 更新一条记录
        Users updateUser = Users.get();
        updateUser.setPassword("keeplearning135");
        var item  = userRepository.save(updateUser);
        return item;
    }

    @GetMapping("/testDelete")
    public boolean testDelete() {
        userRepository.deleteById(2);
        return true;
    }

    @GetMapping("/testSelectById")
    public Optional<Users>  testSelectById() {
        Optional<Users> users = userRepository.findById(1);
        System.out.println(users.get());
        return users;
    }

    @GetMapping("/testSelectByIds")
    public Iterable<Users> testSelectByIds() {
        Iterable<Users> users = userRepository.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
        return users;
    }
}
