package com.keeplearning.springboot_01_jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

/**
 * 用户 DO
 */
@Getter
@Entity
@Table(name = "users")
public class Users {

    /**
     * 用户编号
     */
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY,  generator = "JDBC") // generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
    private Integer id;
    /**
     * 账号
     */
    @Column(nullable = false)
    private String username;
    /**
     * 密码（明文）
     *
     * ps：生产环境下，千万不要明文噢
     */
    @Column(nullable = false)
    private String password;
    /**
     * 创建时间
     */
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
