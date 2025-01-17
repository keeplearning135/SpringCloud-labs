package com.keeplearning.springboot02mybatis.mapper;

import com.keeplearning.springboot02mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserMapper {

    @Insert("INSERT INTO users(username, password, create_time) VALUES(#{username}, #{password}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(User user);

    @Update(value = {
            "<script>",
            "UPDATE users",
            "<set>",
            "<if test='username != null'>, username = #{username}</if>",
            "<if test='password != null'>, password = #{password}</if>",
            "</set>",
            "</script>"
    })
    int updateById(User user);

    @Insert("DELETE FROM users WHERE id = #{id}")
    int deleteById(@Param("id") Integer id); // 生产请使用标记删除，除非有点想不开，嘿嘿。

    @Select("SELECT username, password, create_time FROM users WHERE id = #{id}")
    User selectById(@Param("id") Integer id);

    @Select("SELECT username, password, create_time FROM users WHERE username = #{username}")
    User selectByUsername(@Param("username") String username);

    @Select(value = {
            "<script>",
            "SELECT username, password, create_time FROM users",
            "WHERE id IN",
            "<foreach item='id' collection='ids' separator=',' open='(' close=')' index=''>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<User> selectByIds(@Param("ids") Collection<Integer> ids);

}
