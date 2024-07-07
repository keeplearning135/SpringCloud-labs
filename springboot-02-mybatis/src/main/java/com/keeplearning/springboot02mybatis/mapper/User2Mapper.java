package com.keeplearning.springboot02mybatis.mapper;

import java.util.List;

import com.keeplearning.springboot02mybatis.enums.UserSexEnum;
import com.keeplearning.springboot02mybatis.entity.Users2;
import org.apache.ibatis.annotations.*;

@Mapper
public interface User2Mapper {

    @Select("SELECT * FROM users2")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<Users2> getAll();

    @Select("SELECT * FROM users2 WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    Users2 getOne(Long id);

    @Insert("INSERT INTO users2(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(Users2 user);

    @Update("UPDATE users2 SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(Users2 user);

    @Delete("DELETE FROM users2 WHERE id =#{id}")
    void delete(Long id);

}