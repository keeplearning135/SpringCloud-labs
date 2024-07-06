package com.keeplearning.springboot_01_jpa.repository;

import com.keeplearning.springboot_01_jpa.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface UserRepository03 extends PagingAndSortingRepository<Users, Integer> {

    Users findByUsername(String username);

    Page<Users> findByCreateTimeAfter(Date createTime, Pageable pageable);

}
