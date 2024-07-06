package com.keeplearning.springboot_01_jpa.repository;

import com.keeplearning.springboot_01_jpa.entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository02 extends PagingAndSortingRepository<Users, Integer> {

}
