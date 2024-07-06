package com.keeplearning.springboot_01_jpa.repository;

import com.keeplearning.springboot_01_jpa.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository04 extends PagingAndSortingRepository<Users, Integer> {

    @Query("SELECT u FROM Users u WHERE u.username = ?1")
    Users findByUsername01(String username);

    @Query("SELECT u FROM Users u WHERE u.username = :username")
    Users findByUsername02(@Param("username") String username);

    @Query(value = "SELECT * FROM users u WHERE u.username = :username", nativeQuery = true)
    Users findByUsername03(@Param("username") String username);

    @Query("UPDATE Users  u SET u.username = :username WHERE u.id = :id")
    @Modifying
    int updateUsernameById(Integer id, String username);

}
