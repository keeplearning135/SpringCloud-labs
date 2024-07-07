package com.keeplearning.springboot02mybatis.mapper;

import java.util.List;

import com.keeplearning.springboot02mybatis.enums.UserSexEnum;
import com.keeplearning.springboot02mybatis.entity.Users2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User2MapperTest {

    @Autowired
    private User2Mapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new Users2("aa1", "a123456", UserSexEnum.MAN));
        userMapper.insert(new Users2("bb1", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new Users2("cc1", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<Users2> users = userMapper.getAll();
        System.out.println(users.toString());
    }


    @Test
    public void testUpdate() throws Exception {
        Users2 user = userMapper.getOne(30l);
        System.out.println(user.toString());
        user.setNickName("neo");
        userMapper.update(user);
        Assert.assertTrue(("neo".equals(userMapper.getOne(30l).getNickName())));
    }
}