package com.keeplearning.springboot04security.controller;

import com.keeplearning.springboot04security.entity.Users;
import com.keeplearning.springboot04security.repository.UserRepository04;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user04")
public class User04Controller {

    @Autowired
    private UserRepository04 userRepository;

    @GetMapping("/testFindIdByUsername01")
    public Users testFindIdByUsername01() {
        Users user = userRepository.findByUsername01("yunai");
        System.out.println(user);
        return user;
    }

    @GetMapping("/testFindIdByUsername02")
    public Users testFindIdByUsername02() {
        Users user = userRepository.findByUsername02("yunai");
        System.out.println(user);
        return user;
    }

    @GetMapping("/testFindIdByUsername03")
    public Users testFindIdByUsername03() {
        Users user = userRepository.findByUsername03("yunai");
        System.out.println(user);
        return user;
    }

    @GetMapping("/testUpdateUsernameById")
    // 更新操作，需要在事务中。
    // 在单元测试中，事务默认回滚，所以胖友可能怎么测试，事务都不更新。
    @Transactional
    public boolean testUpdateUsernameById() {
        userRepository.updateUsernameById(5, "keeplearning135");
        return true;
    }
}
