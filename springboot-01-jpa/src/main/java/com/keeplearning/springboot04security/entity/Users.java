package com.keeplearning.springboot04security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;


@Getter
@Entity
@Table(name = "users")
public class Users {


    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY,  generator = "JDBC") // generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    public Users setId(Integer id) {
        this.id = id;
        return this;
    }

    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public Users setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

}
