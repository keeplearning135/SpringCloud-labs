package com.keeplearning.springboot03mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
@TableName("users")
public class User {

    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码（明文）
     *
     * ps：生产环境下，千万不要明文噢
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

}
