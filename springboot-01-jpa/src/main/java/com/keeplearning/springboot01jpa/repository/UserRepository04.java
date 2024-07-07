package com.keeplearning.springboot01jpa.repository;

import com.keeplearning.springboot01jpa.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository04 extends PagingAndSortingRepository<User, Integer> {

    @Query("SELECT u FROM Users u WHERE u.username = ?1")
    User findByUsername01(String username);

    @Query("SELECT u FROM Users u WHERE u.username = :username")
    User findByUsername02(@Param("username") String username);

    @Query(value = "SELECT * FROM users u WHERE u.username = :username", nativeQuery = true)
    User findByUsername03(@Param("username") String username);

    @Query("UPDATE Users  u SET u.username = :username WHERE u.id = :id")
    @Modifying
    int updateUsernameById(Integer id, String username);

}
