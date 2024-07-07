package com.keeplearning.springboot04security.repository;

import com.keeplearning.springboot04security.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepository01Test {

    @Autowired
    private UserRepository01 userRepository;

    @Test // 插入一条记录
    public void testSave() {
        Users user = new Users().setUsername(UUID.randomUUID().toString())
                .setPassword("guess").setCreateTime(new Date());
        userRepository.save(user);
    }

    @Test // 更新一条记录
    public void testUpdate() {
        // 先查询一条记录
        Optional<Users> Users = userRepository.findById(1);
        Assert.isTrue(Users.isPresent(), "记录不能为空");
        // 更新一条记录
        Users updateUser = Users.get();
        updateUser.setPassword("keeplearning135");
        userRepository.save(updateUser);
    }

    @Test // 根据 ID 编号，删除一条记录
    public void testDelete() {
        userRepository.deleteById(2);
    }

    @Test // 根据 ID 编号，查询一条记录
    public void testSelectById() {
        Optional<Users> Users = userRepository.findById(1);
        System.out.println(Users.get());
    }

    @Test // 根据 ID 编号数组，查询多条记录
    public void testSelectByIds() {
        Iterable<Users> users = userRepository.findAllById(Arrays.asList(1, 4));
        users.forEach(System.out::println);
    }

}
