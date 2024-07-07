package com.keeplearning.springboot03mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;


@TableName(value = "users")
public class User2 {


    private Integer id;

    private String username;

    private String password;

    private Date createTime;

    @TableLogic
    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public User2 setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User2 setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User2 setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public User2 setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public User2 setDeleted(Integer deleted) {
        this.deleted = deleted;
        return this;
    }
}
